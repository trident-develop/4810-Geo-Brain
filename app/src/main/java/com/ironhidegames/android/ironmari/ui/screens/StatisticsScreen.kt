package com.ironhidegames.android.ironmari.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoGraph
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Insights
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ironhidegames.android.ironmari.data.GeoTest
import com.ironhidegames.android.ironmari.data.PrefsManager
import com.ironhidegames.android.ironmari.data.TestStats
import com.ironhidegames.android.ironmari.data.TestsData
import com.ironhidegames.android.ironmari.ui.components.GeoCard
import com.ironhidegames.android.ironmari.ui.components.GeoProgress
import com.ironhidegames.android.ironmari.ui.components.GeoTopBar
import com.ironhidegames.android.ironmari.ui.components.Pill
import com.ironhidegames.android.ironmari.ui.theme.CyanAccent
import com.ironhidegames.android.ironmari.ui.theme.GoldAccent
import com.ironhidegames.android.ironmari.ui.theme.RoyalBlue
import com.ironhidegames.android.ironmari.ui.theme.SkyAccent
import com.ironhidegames.android.ironmari.ui.theme.SteelBlue
import com.ironhidegames.android.ironmari.ui.theme.SuccessGreen
import com.ironhidegames.android.ironmari.ui.theme.TextMuted
import com.ironhidegames.android.ironmari.ui.theme.TextPrimary
import com.ironhidegames.android.ironmari.ui.theme.TextSecondary

@Composable
fun StatisticsScreen(prefs: PrefsManager) {
    // Rebuild stats list on each composition so newly finished tests show up.
    val statsList = TestsData.tests.map { test ->
        test to prefs.getStats(test.id, test.questions.size)
    }

    val totals = remember(statsList.hashCode()) {
        val played = statsList.count { it.second.attempts > 0 }
        val completed = statsList.sumOf { it.second.completions }
        val bestPercent = statsList
            .filter { it.second.attempts > 0 }
            .maxOfOrNull {
                it.second.bestScore.toFloat() / it.second.totalQuestions.toFloat()
            }
            ?.times(100f)?.toInt() ?: 0
        Triple(played, completed, bestPercent)
    }

    Column(Modifier.fillMaxSize()) {
        GeoTopBar(
            title = "Statistics",
            subtitle = "Your performance across all 20 tests"
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item { SummaryCard(totals.first, totals.second, totals.third) }
            items(statsList, key = { it.first.id }) { (test, stats) ->
                TestStatCard(test, stats)
            }
        }
    }
}

@Composable
private fun SummaryCard(testsPlayed: Int, completions: Int, bestPercent: Int) {
    GeoCard {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Filled.Insights, null, tint = CyanAccent)
                Spacer(Modifier.size(8.dp))
                Text(
                    "Overall progress",
                    color = TextPrimary,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(Modifier.height(10.dp))
            Row {
                SummaryItem("Tests tried", "$testsPlayed / 20", CyanAccent, Modifier.weight(1f))
                Spacer(Modifier.size(10.dp))
                SummaryItem(
                    "Completions",
                    completions.toString(),
                    SuccessGreen,
                    Modifier.weight(1f)
                )
                Spacer(Modifier.size(10.dp))
                SummaryItem("Top score", "$bestPercent%", GoldAccent, Modifier.weight(1f))
            }
        }
    }
}

@Composable
private fun SummaryItem(label: String, value: String, accent: Color, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            label.uppercase(),
            color = TextMuted,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(Modifier.height(4.dp))
        Text(
            value,
            color = accent,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun TestStatCard(test: GeoTest, stats: TestStats) {
    val played = stats.attempts > 0
    val bestPct = if (stats.totalQuestions == 0) 0f
    else stats.bestScore.toFloat() / stats.totalQuestions.toFloat()
    val avgPct = if (stats.totalQuestions == 0) 0f
    else stats.averageScore / stats.totalQuestions.toFloat()

    GeoCard {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)
                        .background(
                            Brush.linearGradient(listOf(RoyalBlue, SteelBlue))
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(test.emoji, style = MaterialTheme.typography.titleLarge)
                }
                Spacer(Modifier.size(12.dp))
                Column(Modifier.weight(1f)) {
                    Text(
                        "#${test.id}  ${test.title}",
                        color = TextPrimary,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        test.description,
                        color = TextSecondary,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                if (played) {
                    Pill(
                        text = "${(bestPct * 100).toInt()}%",
                        accent = if (bestPct >= 0.8f) SuccessGreen
                        else if (bestPct >= 0.5f) CyanAccent else GoldAccent
                    )
                }
            }
            Spacer(Modifier.height(12.dp))
            if (!played) {
                EmptyTestState()
            } else {
                StatPair(
                    Icons.Filled.EmojiEvents,
                    "Best",
                    "${stats.bestScore} / ${stats.totalQuestions}",
                    SuccessGreen
                )
                Spacer(Modifier.height(6.dp))
                StatPair(
                    Icons.Filled.Replay,
                    "Last",
                    "${stats.lastScore} / ${stats.totalQuestions}",
                    SkyAccent
                )
                Spacer(Modifier.height(6.dp))
                StatPair(
                    Icons.Filled.AutoGraph,
                    "Average",
                    "%.1f / %d".format(stats.averageScore, stats.totalQuestions),
                    CyanAccent
                )
                Spacer(Modifier.height(10.dp))
                Row {
                    Column(Modifier.weight(1f)) {
                        Text(
                            "Best score progress",
                            color = TextMuted,
                            style = MaterialTheme.typography.labelSmall
                        )
                        Spacer(Modifier.height(4.dp))
                        GeoProgress(progress = bestPct)
                    }
                    Spacer(Modifier.size(16.dp))
                    Column(Modifier.weight(1f)) {
                        Text(
                            "Average score",
                            color = TextMuted,
                            style = MaterialTheme.typography.labelSmall
                        )
                        Spacer(Modifier.height(4.dp))
                        GeoProgress(progress = avgPct, accent = GoldAccent)
                    }
                }
                Spacer(Modifier.height(10.dp))
                Row {
                    Pill(text = "Attempts: ${stats.attempts}", accent = SkyAccent)
                    Spacer(Modifier.size(8.dp))
                    Pill(text = "Completed: ${stats.completions}", accent = CyanAccent)
                }
            }
        }
    }
}

@Composable
private fun StatPair(
    icon: ImageVector,
    label: String,
    value: String,
    accent: Color,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, contentDescription = null, tint = accent, modifier = Modifier.size(18.dp))
        Spacer(Modifier.size(8.dp))
        Text(label, color = TextSecondary, style = MaterialTheme.typography.bodyMedium)
        Spacer(Modifier.weight(1f))
        Text(
            value,
            color = TextPrimary,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun EmptyTestState() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Filled.AutoGraph, null, tint = TextMuted)
        Spacer(Modifier.size(10.dp))
        Column {
            Text(
                "No attempts yet",
                color = TextSecondary,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                "Take this test to start building stats.",
                color = TextMuted,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
