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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.SquareFoot
import androidx.compose.material.icons.filled.WbSunny
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
import com.bigcool.puzzle.merge.c.data.CountriesData
import com.bigcool.puzzle.merge.c.ui.components.FactRow
import com.bigcool.puzzle.merge.c.ui.components.GeoCard
import com.bigcool.puzzle.merge.c.ui.components.GeoTopBar
import com.bigcool.puzzle.merge.c.ui.components.Pill
import com.bigcool.puzzle.merge.c.ui.components.ScreenBackground
import com.bigcool.puzzle.merge.c.ui.components.SectionTitle
import com.bigcool.puzzle.merge.c.ui.components.WrapRow
import com.bigcool.puzzle.merge.c.ui.theme.CardBlue
import com.bigcool.puzzle.merge.c.ui.theme.CyanAccent
import com.bigcool.puzzle.merge.c.ui.theme.GoldAccent
import com.bigcool.puzzle.merge.c.ui.theme.RoyalBlue
import com.bigcool.puzzle.merge.c.ui.theme.SkyAccent
import com.bigcool.puzzle.merge.c.ui.theme.SteelBlue
import com.bigcool.puzzle.merge.c.ui.theme.TextPrimary
import com.bigcool.puzzle.merge.c.ui.theme.TextSecondary

@Composable
fun CountryDetailScreen(countryId: String, onBack: () -> Unit) {
    val country = CountriesData.findCountry(countryId)
    val continent = country?.let { CountriesData.findContinent(it.continentId) }

    ScreenBackground {
        Column(Modifier.fillMaxSize()) {
            GeoTopBar(
                title = country?.name ?: "Country",
                subtitle = continent?.name,
                showBack = true,
                onBack = onBack,
                topPadding = 48.dp,
                bottomPadding = 10.dp
            )

            if (country == null) {
                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Country not found",
                        color = TextSecondary,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                return@Column
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                HeroCard(country.flagEmoji, country.name, continent?.name.orEmpty())

                GeoCard {
                    Column {
                        SectionTitle("Key facts")
                        FactRow(
                            icon = { Icon(Icons.Filled.LocationCity, null, tint = SkyAccent) },
                            label = "Capital", value = country.capital
                        )
                        FactRow(
                            icon = { Icon(Icons.Filled.Groups, null, tint = SkyAccent) },
                            label = "Population", value = country.population
                        )
                        FactRow(
                            icon = { Icon(Icons.Filled.SquareFoot, null, tint = SkyAccent) },
                            label = "Area", value = country.area
                        )
                        FactRow(
                            icon = { Icon(Icons.Filled.Language, null, tint = SkyAccent) },
                            label = "Official language", value = country.language
                        )
                        FactRow(
                            icon = { Icon(Icons.Filled.AttachMoney, null, tint = SkyAccent) },
                            label = "Currency", value = country.currency
                        )
                        FactRow(
                            icon = { Icon(Icons.Filled.WbSunny, null, tint = SkyAccent) },
                            label = "Climate", value = country.climate
                        )
                        FactRow(
                            icon = { Icon(Icons.Filled.Public, null, tint = SkyAccent) },
                            label = "Continent", value = continent?.name ?: "—"
                        )
                    }
                }

                GeoCard {
                    Column {
                        SectionTitle("Famous landmarks")
                        WrapRow {
                            country.landmarks.forEach { landmark ->
                                Pill(text = landmark, accent = GoldAccent)
                            }
                        }
                    }
                }

                GeoCard {
                    Column {
                        SectionTitle("Neighboring countries")
                        if (country.neighbors.isEmpty()) {
                            Text(
                                "No land neighbors.",
                                color = TextSecondary,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        } else {
                            WrapRow {
                                country.neighbors.forEach { name ->
                                    Pill(text = name, accent = CyanAccent)
                                }
                            }
                        }
                    }
                }

                GeoCard {
                    Column {
                        SectionTitle("Interesting facts")
                        country.facts.forEachIndexed { index, fact ->
                            FactBullet(index + 1, fact)
                            if (index != country.facts.lastIndex) Spacer(Modifier.height(10.dp))
                        }
                    }
                }

                Spacer(Modifier.height(8.dp))
            }
        }
    }
}

@Composable
private fun HeroCard(flag: String, name: String, continentName: String) {
    GeoCard(padding = PaddingValues(0.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        listOf(RoyalBlue, SteelBlue.copy(alpha = 0.7f), CardBlue)
                    )
                )
                .padding(20.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                        .background(CardBlue),
                    contentAlignment = Alignment.Center
                ) {
                    Text(flag, style = MaterialTheme.typography.displayMedium)
                }
                Spacer(Modifier.size(16.dp))
                Column(Modifier.weight(1f)) {
                    Text(
                        name,
                        color = TextPrimary,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Filled.Map,
                            contentDescription = null,
                            tint = SkyAccent,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(Modifier.size(6.dp))
                        Text(
                            continentName,
                            color = TextSecondary,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun FactBullet(index: Int, text: String) {
    Row(verticalAlignment = Alignment.Top) {
        Box(
            modifier = Modifier
                .size(26.dp)
                .clip(CircleShape)
                .background(
                    Brush.linearGradient(listOf(RoyalBlue, SteelBlue))
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = index.toString(),
                color = TextPrimary,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(Modifier.size(10.dp))
        Text(
            text,
            color = TextPrimary,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 3.dp)
        )
    }
}
