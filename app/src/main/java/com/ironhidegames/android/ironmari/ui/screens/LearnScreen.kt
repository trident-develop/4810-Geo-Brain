package com.ironhidegames.android.ironmari.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ironhidegames.android.ironmari.data.Continent
import com.ironhidegames.android.ironmari.data.CountriesData
import com.ironhidegames.android.ironmari.data.Country
import com.ironhidegames.android.ironmari.ui.components.GeoCard
import com.ironhidegames.android.ironmari.ui.components.GeoTopBar
import com.ironhidegames.android.ironmari.ui.components.Pill
import com.ironhidegames.android.ironmari.ui.theme.CardBlue
import com.ironhidegames.android.ironmari.ui.theme.CardBlueLight
import com.ironhidegames.android.ironmari.ui.theme.CyanAccent
import com.ironhidegames.android.ironmari.ui.theme.GoldAccent
import com.ironhidegames.android.ironmari.ui.theme.RoyalBlue
import com.ironhidegames.android.ironmari.ui.theme.SkyAccent
import com.ironhidegames.android.ironmari.ui.theme.SteelBlue
import com.ironhidegames.android.ironmari.ui.theme.TextMuted
import com.ironhidegames.android.ironmari.ui.theme.TextPrimary
import com.ironhidegames.android.ironmari.ui.theme.TextSecondary

@Composable
fun LearnScreen(onOpenCountry: (String) -> Unit) {
    var expandedId by remember { mutableStateOf<String?>(null) }

    Column(Modifier.fillMaxSize()) {
        GeoTopBar(
            title = "Learn Geography",
            subtitle = "Explore continents and countries"
        )
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(CountriesData.continents, key = { it.id }) { continent ->
                ContinentBlock(
                    continent = continent,
                    expanded = expandedId == continent.id,
                    onToggle = {
                        expandedId = if (expandedId == continent.id) null else continent.id
                    },
                    onOpenCountry = onOpenCountry
                )
            }
        }
    }
}

@Composable
private fun ContinentBlock(
    continent: Continent,
    expanded: Boolean,
    onToggle: () -> Unit,
    onOpenCountry: (String) -> Unit,
) {
    val arrowRotation by animateFloatAsState(
        if (expanded) 180f else 0f, label = "arrow"
    )

    GeoCard(padding = PaddingValues(0.dp), onClick = onToggle) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(52.dp)
                        .clip(CircleShape)
                        .background(
                            Brush.linearGradient(
                                listOf(RoyalBlue, SteelBlue)
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = continent.emoji,
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
                Spacer(Modifier.size(14.dp))
                Column(Modifier.weight(1f)) {
                    Text(
                        text = continent.name,
                        color = TextPrimary,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(2.dp))
                    Text(
                        text = continent.description,
                        color = TextSecondary,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(Modifier.height(6.dp))
                    Pill(
                        text = if (continent.isSpecial) "Special"
                        else "${continent.countries.size} countries",
                        accent = if (continent.isSpecial) GoldAccent else CyanAccent
                    )
                }
                Icon(
                    Icons.Filled.ExpandMore,
                    contentDescription = null,
                    tint = SkyAccent,
                    modifier = Modifier.rotate(arrowRotation)
                )
            }

            AnimatedVisibility(
                visible = expanded,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    if (continent.isSpecial) {
                        AntarcticaCard(info = continent.specialInfo.orEmpty())
                    } else {
                        continent.countries.forEach { country ->
                            CountryRow(country = country, onClick = { onOpenCountry(country.id) })
                            Spacer(Modifier.height(8.dp))
                        }
                        Spacer(Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}

@Composable
private fun CountryRow(country: Country, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(
                Brush.horizontalGradient(
                    listOf(CardBlueLight, CardBlue)
                )
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 14.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(country.flagEmoji, style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.size(12.dp))
        Column(Modifier.weight(1f)) {
            Text(
                text = country.name,
                color = TextPrimary,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Capital: ${country.capital}",
                color = TextMuted,
                style = MaterialTheme.typography.bodySmall
            )
        }
        Icon(
            Icons.Filled.ChevronRight,
            contentDescription = null,
            tint = SkyAccent
        )
    }
}

@Composable
private fun AntarcticaCard(info: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(
                Brush.Companion.linearGradient(
                    listOf(RoyalBlue.copy(alpha = 0.35f), CardBlue)
                )
            )
            .padding(16.dp)
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("❄️", style = MaterialTheme.typography.headlineMedium)
                Spacer(Modifier.size(10.dp))
                Text(
                    text = "About Antarctica",
                    color = TextPrimary,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(Modifier.height(10.dp))
            Text(
                text = info,
                color = TextSecondary,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
