package com.ironhidegames.android.ironmari.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ironhidegames.android.ironmari.data.PrefsManager
import com.ironhidegames.android.ironmari.data.Question
import com.ironhidegames.android.ironmari.data.TestsData
import com.ironhidegames.android.ironmari.ui.Screen
import com.ironhidegames.android.ironmari.ui.components.GeoCard
import com.ironhidegames.android.ironmari.ui.components.GeoProgress
import com.ironhidegames.android.ironmari.ui.components.GeoTopBar
import com.ironhidegames.android.ironmari.ui.components.PrimaryButton
import com.ironhidegames.android.ironmari.ui.components.ScreenBackground
import com.ironhidegames.android.ironmari.ui.theme.CardBlue
import com.ironhidegames.android.ironmari.ui.theme.Divider
import com.ironhidegames.android.ironmari.ui.theme.ErrorRed
import com.ironhidegames.android.ironmari.ui.theme.GoldAccent
import com.ironhidegames.android.ironmari.ui.theme.RoyalBlue
import com.ironhidegames.android.ironmari.ui.theme.SkyAccent
import com.ironhidegames.android.ironmari.ui.theme.SteelBlue
import com.ironhidegames.android.ironmari.ui.theme.SuccessGreen
import com.ironhidegames.android.ironmari.ui.theme.TextPrimary
import com.ironhidegames.android.ironmari.ui.theme.TextSecondary
import kotlinx.coroutines.delay

private const val TEST_DURATION_SECONDS = 5 * 60

@Composable
fun TestTakingScreen(
    testId: Int,
    prefs: PrefsManager,
    onFinish: (Screen.TestResult) -> Unit,
    onBack: () -> Unit,
) {
    val test = TestsData.findTest(testId)
    if (test == null) {
        ScreenBackground {
            Column(Modifier.fillMaxSize()) {
                GeoTopBar(title = "Test", showBack = true, onBack = onBack)
                Box(Modifier.fillMaxSize().padding(24.dp), contentAlignment = Alignment.Center) {
                    Text("Test not found", color = TextSecondary)
                }
            }
        }
        return
    }

    var secondsLeft by remember(testId) { mutableIntStateOf(TEST_DURATION_SECONDS) }
    var currentIndex by remember(testId) { mutableIntStateOf(0) }
    var selected by remember(testId) { mutableStateOf<Int?>(null) }
    var revealed by remember(testId) { mutableStateOf(false) }
    var correctCount by remember(testId) { mutableIntStateOf(0) }
    var finished by remember(testId) { mutableStateOf(false) }

    // Countdown
    LaunchedEffect(testId) {
        while (secondsLeft > 0 && !finished) {
            delay(1000L)
            secondsLeft -= 1
        }
        if (secondsLeft <= 0 && !finished) {
            finished = true
            val incorrect = (currentIndex) - correctCount
            val incorrectClamped = if (incorrect < 0) 0 else incorrect
            prefs.recordAttempt(
                testId = testId,
                score = correctCount,
                totalQuestions = test.questions.size,
                completed = false
            )
            onFinish(
                Screen.TestResult(
                    testId = testId,
                    score = correctCount,
                    total = test.questions.size,
                    correct = correctCount,
                    incorrect = incorrectClamped,
                    timeExpired = true
                )
            )
        }
    }

    val question = test.questions[currentIndex]
    val progress = (currentIndex + if (revealed) 1 else 0).toFloat() / test.questions.size.toFloat()

    ScreenBackground {
        Column(Modifier.fillMaxSize()) {
            GeoTopBar(
                title = test.title,
                subtitle = "Question ${currentIndex + 1} of ${test.questions.size}",
                showBack = true,
                onBack = onBack,
                trailing = { TimerChip(secondsLeft) },
                topPadding = 48.dp,
                bottomPadding = 10.dp
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                GeoProgress(progress = progress)

                AnimatedContent(
                    targetState = currentIndex,
                    transitionSpec = {
                        (slideInHorizontally { it / 3 } + fadeIn()) togetherWith
                                (slideOutHorizontally { -it / 3 } + fadeOut())
                    },
                    label = "question"
                ) { idx ->
                    QuestionCard(
                        question = test.questions[idx],
                        selected = selected,
                        revealed = revealed,
                        onSelect = { picked ->
                            if (!revealed) {
                                selected = picked
                                revealed = true
                                if (picked == test.questions[idx].correctIndex) correctCount += 1
                            }
                        }
                    )
                }

                Spacer(Modifier.weight(1f))

                PrimaryButton(
                    text = if (currentIndex == test.questions.lastIndex) "Finish test"
                    else "Next question",
                    onClick = {
                        if (!revealed) return@PrimaryButton
                        if (currentIndex == test.questions.lastIndex) {
                            if (!finished) {
                                finished = true
                                val incorrect = test.questions.size - correctCount
                                prefs.recordAttempt(
                                    testId = testId,
                                    score = correctCount,
                                    totalQuestions = test.questions.size,
                                    completed = true
                                )
                                onFinish(
                                    Screen.TestResult(
                                        testId = testId,
                                        score = correctCount,
                                        total = test.questions.size,
                                        correct = correctCount,
                                        incorrect = incorrect,
                                        timeExpired = false
                                    )
                                )
                            }
                        } else {
                            currentIndex += 1
                            selected = null
                            revealed = false
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = revealed
                )

                Spacer(Modifier.height(4.dp))
            }
        }
    }
}

@Composable
private fun TimerChip(seconds: Int) {
    val mm = seconds / 60
    val ss = seconds % 60
    val danger = seconds <= 30
    val accent = if (danger) ErrorRed else GoldAccent
    Row(
        modifier = Modifier
            .padding(end = 8.dp)
            .clip(CircleShape)
            .background(accent.copy(alpha = 0.15f))
            .border(1.dp, accent.copy(alpha = 0.6f), CircleShape)
            .padding(horizontal = 12.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Filled.Timer, contentDescription = null,
            tint = accent,
            modifier = Modifier.size(16.dp)
        )
        Spacer(Modifier.size(6.dp))
        Text(
            text = "%d:%02d".format(mm, ss),
            color = accent,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun QuestionCard(
    question: Question,
    selected: Int?,
    revealed: Boolean,
    onSelect: (Int) -> Unit,
) {
    GeoCard(padding = PaddingValues(20.dp)) {
        Column {
            Text(
                text = question.text,
                color = TextPrimary,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(Modifier.height(18.dp))
            question.options.forEachIndexed { index, label ->
                AnswerOption(
                    label = label,
                    index = index,
                    selected = selected == index,
                    revealed = revealed,
                    isCorrect = index == question.correctIndex,
                    onSelect = { onSelect(index) }
                )
                if (index != question.options.lastIndex) Spacer(Modifier.height(10.dp))
            }
        }
    }
}

@Composable
private fun AnswerOption(
    label: String,
    index: Int,
    selected: Boolean,
    revealed: Boolean,
    isCorrect: Boolean,
    onSelect: () -> Unit,
) {
    val letter = ('A' + index).toString()

    val (borderColor, bgBrush, textColor, trailingIcon) = when {
        revealed && isCorrect -> Quadruple(
            SuccessGreen,
            Brush.Companion.horizontalGradient(listOf(SuccessGreen.copy(alpha = 0.18f), CardBlue)),
            TextPrimary,
            Icons.Filled.Check to SuccessGreen
        )
        revealed && selected && !isCorrect -> Quadruple(
            ErrorRed,
            Brush.Companion.horizontalGradient(listOf(ErrorRed.copy(alpha = 0.18f), CardBlue)),
            TextPrimary,
            Icons.Filled.Close to ErrorRed
        )
        selected -> Quadruple(
            SkyAccent,
            Brush.Companion.horizontalGradient(listOf(RoyalBlue, SteelBlue.copy(alpha = 0.6f))),
            TextPrimary,
            null
        )
        else -> Quadruple(
            Divider,
            Brush.horizontalGradient(listOf(CardBlue, CardBlue)),
            TextPrimary,
            null
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(bgBrush)
            .border(1.dp, borderColor, RoundedCornerShape(16.dp))
            .clickable(enabled = !revealed) { onSelect() }
            .padding(horizontal = 14.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(
                    Brush.linearGradient(listOf(RoyalBlue, SteelBlue))
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                letter,
                color = TextPrimary,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(Modifier.size(12.dp))
        Text(
            label,
            color = textColor,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        if (trailingIcon != null) {
            Icon(
                trailingIcon.first,
                contentDescription = null,
                tint = trailingIcon.second
            )
        }
    }
}

private data class Quadruple<A, B, C, D>(
    val a: A, val b: B, val c: C, val d: D
)
