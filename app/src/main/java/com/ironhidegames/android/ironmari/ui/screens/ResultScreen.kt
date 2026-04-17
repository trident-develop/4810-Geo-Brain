package com.ironhidegames.android.ironmari.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.HourglassBottom
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ironhidegames.android.ironmari.data.TestsData
import com.ironhidegames.android.ironmari.ui.Screen
import com.ironhidegames.android.ironmari.ui.components.GeoCard
import com.ironhidegames.android.ironmari.ui.components.GeoTopBar
import com.ironhidegames.android.ironmari.ui.components.PrimaryButton
import com.ironhidegames.android.ironmari.ui.components.ScreenBackground
import com.ironhidegames.android.ironmari.ui.components.SecondaryButton
import com.ironhidegames.android.ironmari.ui.components.StatTile
import com.ironhidegames.android.ironmari.ui.theme.CyanAccent
import com.ironhidegames.android.ironmari.ui.theme.ErrorRed
import com.ironhidegames.android.ironmari.ui.theme.GoldAccent
import com.ironhidegames.android.ironmari.ui.theme.MidnightBlue
import com.ironhidegames.android.ironmari.ui.theme.SkyAccent
import com.ironhidegames.android.ironmari.ui.theme.SuccessGreen
import com.ironhidegames.android.ironmari.ui.theme.TextPrimary
import com.ironhidegames.android.ironmari.ui.theme.TextSecondary

@Composable
fun ResultScreen(
    result: Screen.TestResult,
    onRetry: () -> Unit,
    onBack: () -> Unit,
) {
    val test = TestsData.findTest(result.testId)
    val percent = if (result.total == 0) 0f else result.score.toFloat() / result.total.toFloat()
    val percentInt = (percent * 100).toInt()

    val accent = when {
        percent >= 0.8f -> SuccessGreen
        percent >= 0.5f -> CyanAccent
        else -> GoldAccent
    }
    val headline = when {
        result.timeExpired -> "Time is up!"
        percent >= 0.8f -> "Excellent!"
        percent >= 0.5f -> "Nicely done"
        else -> "Keep practicing"
    }
    val subline = if (result.timeExpired) "You ran out of time — try again to finish."
    else "You completed the test."

    var animateTrigger by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { animateTrigger = true }
    val animatedPercent by animateFloatAsState(
        targetValue = if (animateTrigger) percent else 0f,
        animationSpec = tween(durationMillis = 900),
        label = "pct"
    )

    ScreenBackground {
        Column(Modifier.fillMaxSize()) {
            GeoTopBar(
                title = "Results",
                subtitle = test?.title,
                showBack = true,
                onBack = onBack
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                GeoCard(padding = PaddingValues(24.dp)) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            ScoreRing(progress = animatedPercent, accent = accent)
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    "$percentInt%",
                                    color = TextPrimary,
                                    style = MaterialTheme.typography.displayLarge,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    "${result.score} / ${result.total}",
                                    color = TextSecondary,
                                    style = MaterialTheme.typography.labelLarge
                                )
                            }
                        }
                        Spacer(Modifier.height(18.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                if (result.timeExpired) Icons.Filled.HourglassBottom
                                else Icons.Filled.EmojiEvents,
                                contentDescription = null,
                                tint = accent
                            )
                            Spacer(Modifier.size(8.dp))
                            Text(
                                headline,
                                color = TextPrimary,
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(Modifier.height(4.dp))
                        Text(
                            subline,
                            color = TextSecondary,
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    StatTile(
                        label = "Correct",
                        value = result.correct.toString(),
                        accent = SuccessGreen,
                        modifier = Modifier.weight(1f)
                    )
                    StatTile(
                        label = "Incorrect",
                        value = result.incorrect.toString(),
                        accent = ErrorRed,
                        modifier = Modifier.weight(1f)
                    )
                }
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    StatTile(
                        label = "Outcome",
                        value = if (result.timeExpired) "Time expired" else "Completed",
                        accent = if (result.timeExpired) GoldAccent else CyanAccent,
                        modifier = Modifier.weight(1f)
                    )
                    StatTile(
                        label = "Score",
                        value = "${result.score}/${result.total}",
                        accent = SkyAccent,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(Modifier.weight(1f))

                PrimaryButton(
                    text = "Retry test",
                    onClick = onRetry,
                    modifier = Modifier.fillMaxWidth()
                )
                SecondaryButton(
                    text = "Back to tests",
                    onClick = onBack,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(4.dp))
            }
        }
    }
}

@Composable
private fun ScoreRing(progress: Float, accent: Color) {
    Canvas(
        modifier = Modifier.size(180.dp)
    ) {
        val stroke = 14f
        val arcSize = Size(size.width - stroke, size.height - stroke)
        val topLeft = Offset(stroke / 2f, stroke / 2f)
        drawArc(
            color = MidnightBlue,
            startAngle = 0f,
            sweepAngle = 360f,
            useCenter = false,
            topLeft = topLeft,
            size = arcSize,
            style = Stroke(width = stroke)
        )
        drawArc(
            brush = Brush.sweepGradient(listOf(accent.copy(alpha = 0.4f), accent)),
            startAngle = -90f,
            sweepAngle = 360f * progress.coerceIn(0f, 1f),
            useCenter = false,
            topLeft = topLeft,
            size = arcSize,
            style = Stroke(width = stroke)
        )
    }
}
