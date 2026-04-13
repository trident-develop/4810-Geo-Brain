package com.bigcool.puzzle.merge.c.ui.screens

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
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bigcool.puzzle.merge.c.data.GeoTest
import com.bigcool.puzzle.merge.c.data.TestsData
import com.bigcool.puzzle.merge.c.ui.components.GeoCard
import com.bigcool.puzzle.merge.c.ui.components.GeoTopBar
import com.bigcool.puzzle.merge.c.ui.theme.CardBlue
import com.bigcool.puzzle.merge.c.ui.theme.CyanAccent
import com.bigcool.puzzle.merge.c.ui.theme.RoyalBlue
import com.bigcool.puzzle.merge.c.ui.theme.SkyAccent
import com.bigcool.puzzle.merge.c.ui.theme.SteelBlue
import com.bigcool.puzzle.merge.c.ui.theme.TextMuted
import com.bigcool.puzzle.merge.c.ui.theme.TextPrimary
import com.bigcool.puzzle.merge.c.ui.theme.TextSecondary

@Composable
fun TestsScreen(onOpenTest: (Int) -> Unit) {
    Column(Modifier.fillMaxSize()) {
        GeoTopBar(
            title = "Geography Tests",
            subtitle = "20 themed challenges, 5 minutes each"
        )
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(TestsData.tests, key = { it.id }) { test ->
                TestRowCard(test = test, onClick = { onOpenTest(test.id) })
            }
        }
    }
}

@Composable
private fun TestRowCard(test: GeoTest, onClick: () -> Unit) {
    GeoCard(onClick = onClick, padding = PaddingValues(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(
                        Brush.linearGradient(listOf(RoyalBlue, SteelBlue))
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    test.emoji,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            Spacer(Modifier.size(14.dp))
            Column(Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "#${test.id}",
                        color = CyanAccent,
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.size(8.dp))
                    Text(
                        text = test.title,
                        color = TextPrimary,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Spacer(Modifier.height(3.dp))
                Text(
                    test.description,
                    color = TextSecondary,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(Modifier.height(6.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Filled.Timer,
                        contentDescription = null,
                        tint = TextMuted,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(Modifier.size(4.dp))
                    Text(
                        "5:00",
                        color = TextMuted,
                        style = MaterialTheme.typography.labelSmall
                    )
                    Spacer(Modifier.size(12.dp))
                    Text(
                        "${test.questions.size} questions",
                        color = TextMuted,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
            Icon(
                Icons.Filled.ChevronRight,
                contentDescription = null,
                tint = SkyAccent
            )
        }
    }
}
