package com.ironhidegames.android.ironmari.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.foundation.clickable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ironhidegames.android.ironmari.data.PrefsManager
import com.ironhidegames.android.ironmari.ui.components.ScreenBackground
import com.ironhidegames.android.ironmari.ui.theme.CardBlue
import com.ironhidegames.android.ironmari.ui.theme.CardBlueLight
import com.ironhidegames.android.ironmari.ui.theme.DeepNavy
import com.ironhidegames.android.ironmari.ui.theme.MidnightBlue
import com.ironhidegames.android.ironmari.ui.theme.SkyAccent
import com.ironhidegames.android.ironmari.ui.theme.TextMuted

enum class Tab(val title: String, val icon: ImageVector) {
    Learn("Learn", Icons.Filled.MenuBook),
    Tests("Tests", Icons.Filled.Quiz),
    Stats("Statistics", Icons.Filled.BarChart)
}

@Composable
fun MainScreen(
    prefs: PrefsManager,
    currentTab: Tab,
    onTabChange: (Tab) -> Unit,
    onOpenCountry: (String) -> Unit,
    onOpenTest: (Int) -> Unit,
) {
    ScreenBackground {
        Scaffold(
            containerColor = Color.Transparent,
            bottomBar = {
                GeoBottomBar(
                    current = currentTab,
                    onTabSelected = onTabChange
                )
            }
        ) { inner ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(inner)
            ) {
                AnimatedContent(
                    targetState = currentTab,
                    transitionSpec = { fadeIn() togetherWith fadeOut() },
                    label = "tabs"
                ) { tab ->
                    when (tab) {
                        Tab.Learn -> LearnScreen(onOpenCountry = onOpenCountry)
                        Tab.Tests -> TestsScreen(onOpenTest = onOpenTest)
                        Tab.Stats -> StatisticsScreen(prefs = prefs)
                    }
                }
            }
        }
    }
}

@Composable
private fun GeoBottomBar(current: Tab, onTabSelected: (Tab) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(16.dp)
            .background(
                Brush.verticalGradient(
                    listOf(MidnightBlue, DeepNavy)
                )
            )
            .padding(horizontal = 12.dp, vertical = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Tab.entries.forEach { tab ->
                BottomTabItem(
                    tab = tab,
                    selected = tab == current,
                    onClick = { onTabSelected(tab) }
                )
            }
        }
    }
}

@Composable
private fun BottomTabItem(tab: Tab, selected: Boolean, onClick: () -> Unit) {
    val background = if (selected) {
        Brush.horizontalGradient(listOf(CardBlueLight, CardBlue))
    } else {
        Brush.horizontalGradient(listOf(Color.Transparent, Color.Transparent))
    }
    val contentColor = if (selected) SkyAccent else TextMuted
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(18.dp))
            .background(background)
            .clickable { onClick() }
            .padding(horizontal = 14.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            tab.icon, contentDescription = tab.title,
            tint = contentColor,
            modifier = Modifier.size(22.dp)
        )
        if (selected) {
            Spacer(Modifier.size(6.dp))
            Text(
                text = tab.title,
                color = contentColor,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
