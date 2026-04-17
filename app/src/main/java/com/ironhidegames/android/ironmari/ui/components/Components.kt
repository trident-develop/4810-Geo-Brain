package com.ironhidegames.android.ironmari.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ironhidegames.android.ironmari.ui.theme.CardBlue
import com.ironhidegames.android.ironmari.ui.theme.CardBlueLight
import com.ironhidegames.android.ironmari.ui.theme.CyanAccent
import com.ironhidegames.android.ironmari.ui.theme.DeepNavy
import com.ironhidegames.android.ironmari.ui.theme.Divider
import com.ironhidegames.android.ironmari.ui.theme.MidnightBlue
import com.ironhidegames.android.ironmari.ui.theme.RoyalBlue
import com.ironhidegames.android.ironmari.ui.theme.SkyAccent
import com.ironhidegames.android.ironmari.ui.theme.SteelBlue
import com.ironhidegames.android.ironmari.ui.theme.TextMuted
import com.ironhidegames.android.ironmari.ui.theme.TextPrimary
import com.ironhidegames.android.ironmari.ui.theme.TextSecondary

/** Vertical background gradient used on every screen. */
@Composable
fun ScreenBackground(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(DeepNavy, MidnightBlue, DeepNavy)
                )
            )
    ) {
        content()
    }
}

/** Elegant top bar with optional back button and trailing content. */
@Composable
fun GeoTopBar(
    title: String,
    subtitle: String? = null,
    showBack: Boolean = false,
    onBack: (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    topPadding: Dp = 14.dp,
    bottomPadding: Dp = 14.dp,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp),
        color = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.Companion.horizontalGradient(
                        listOf(MidnightBlue, RoyalBlue.copy(alpha = 0.55f), MidnightBlue)
                    )
                )
                .padding(
                    start = 12.dp,
                    end = 12.dp,
                    top = topPadding,
                    bottom = bottomPadding
                )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (showBack) {
                    IconButton(onClick = { onBack?.invoke() }) {
                        Icon(
                            Icons.Filled.ArrowBackIosNew,
                            contentDescription = "Back",
                            tint = SkyAccent
                        )
                    }
                } else {
                    Spacer(Modifier.width(12.dp))
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 4.dp)
                ) {
                    Text(
                        text = title,
                        color = TextPrimary,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                    if (subtitle != null) {
                        Text(
                            text = subtitle,
                            color = TextSecondary,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
                if (trailing != null) trailing()
            }
        }
    }
}

/** Card with subtle gradient and border — base for all content cards. */
@Composable
fun GeoCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    padding: PaddingValues = PaddingValues(16.dp),
    content: @Composable () -> Unit
) {
    val shape = RoundedCornerShape(20.dp)
    val clickable = if (onClick != null) Modifier.clickable(onClick = onClick) else Modifier
    Box(
        modifier = modifier
            .shadow(6.dp, shape)
            .clip(shape)
            .background(
                Brush.linearGradient(
                    colors = listOf(CardBlue, CardBlueLight)
                )
            )
            .border(1.dp, Divider, shape)
            .then(clickable)
            .padding(padding)
    ) {
        content()
    }
}

/** Big primary action button with a cyan gradient. */
@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    val alpha by animateFloatAsState(if (enabled) 1f else 0.4f, label = "btnAlpha")
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(18.dp))
            .background(
                Brush.horizontalGradient(
                    colors = listOf(SteelBlue, CyanAccent)
                )
            )
            .clickable(enabled = enabled) { onClick() }
            .padding(horizontal = 24.dp, vertical = 14.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = DeepNavy,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.labelLarge.copy(
                color = DeepNavy.copy(alpha = alpha)
            ),
            textAlign = TextAlign.Center
        )
    }
}

/** Outlined secondary button in dark-blue tones. */
@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(18.dp))
            .background(CardBlue)
            .border(1.dp, SkyAccent.copy(alpha = 0.6f), RoundedCornerShape(18.dp))
            .clickable { onClick() }
            .padding(horizontal = 24.dp, vertical = 14.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = SkyAccent,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

/** Labeled stat card used in Statistics tab and Result screen. */
@Composable
fun StatTile(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    accent: Color = SkyAccent,
) {
    GeoCard(
        modifier = modifier,
        padding = PaddingValues(14.dp)
    ) {
        Column {
            Text(
                text = label.uppercase(),
                color = TextMuted,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(Modifier.height(6.dp))
            Text(
                text = value,
                color = accent,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

/** Linear progress with rounded look, used in statistics rows. */
@Composable
fun GeoProgress(
    progress: Float,
    modifier: Modifier = Modifier,
    accent: Color = CyanAccent,
) {
    LinearProgressIndicator(
        progress = { progress.coerceIn(0f, 1f) },
        modifier = modifier
            .fillMaxWidth()
            .height(8.dp)
            .clip(CircleShape),
        color = accent,
        trackColor = MidnightBlue,
        gapSize = 0.dp,
        drawStopIndicator = {}
    )
}

/** Fact row for the country details screen. */
@Composable
fun FactRow(
    icon: @Composable () -> Unit,
    label: String,
    value: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(38.dp)
                .clip(CircleShape)
                .background(
                    Brush.linearGradient(
                        listOf(RoyalBlue, SteelBlue)
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            icon()
        }
        Spacer(Modifier.width(12.dp))
        Column(Modifier.weight(1f)) {
            Text(
                text = label,
                color = TextMuted,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = value,
                color = TextPrimary,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

/** Section header used in country details and test detail views. */
@Composable
fun SectionTitle(text: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(width = 4.dp, height = 20.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(
                    Brush.verticalGradient(
                        listOf(CyanAccent, SkyAccent)
                    )
                )
        )
        Spacer(Modifier.width(8.dp))
        Text(
            text = text,
            color = TextPrimary,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
    }
}

/**
 * A simple wrap layout that lays out children horizontally and wraps to a new
 * row when the current row runs out of space. Used for pill/tag groups.
 */
@Composable
fun WrapRow(
    horizontalSpacing: Dp = 8.dp,
    verticalSpacing: Dp = 8.dp,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        val hGap = horizontalSpacing.roundToPx()
        val vGap = verticalSpacing.roundToPx()
        val maxWidth = constraints.maxWidth
        val placeables = measurables.map { it.measure(constraints.copy(minWidth = 0)) }

        val rows = mutableListOf<MutableList<Placeable>>()
        var currentRow = mutableListOf<Placeable>()
        var currentRowWidth = 0
        for (p in placeables) {
            val added = if (currentRow.isEmpty()) p.width else currentRowWidth + hGap + p.width
            if (added > maxWidth && currentRow.isNotEmpty()) {
                rows.add(currentRow)
                currentRow = mutableListOf(p)
                currentRowWidth = p.width
            } else {
                currentRow.add(p)
                currentRowWidth = added
            }
        }
        if (currentRow.isNotEmpty()) rows.add(currentRow)

        val rowHeights = rows.map { row -> row.maxOfOrNull { it.height } ?: 0 }
        val totalHeight = rowHeights.sum() + vGap * (rows.size - 1).coerceAtLeast(0)
        val layoutWidth = maxWidth.coerceIn(constraints.minWidth, constraints.maxWidth)
        val layoutHeight = totalHeight.coerceIn(constraints.minHeight, constraints.maxHeight)

        layout(layoutWidth, layoutHeight) {
            var y = 0
            rows.forEachIndexed { index, row ->
                var x = 0
                row.forEach { p ->
                    p.placeRelative(x, y)
                    x += p.width + hGap
                }
                y += rowHeights[index] + vGap
            }
        }
    }
}

/** Small informational pill/tag. */
@Composable
fun Pill(text: String, accent: Color = SkyAccent) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(accent.copy(alpha = 0.12f))
            .border(1.dp, accent.copy(alpha = 0.4f), CircleShape)
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(
            text = text,
            color = accent,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.SemiBold
        )
    }
}
