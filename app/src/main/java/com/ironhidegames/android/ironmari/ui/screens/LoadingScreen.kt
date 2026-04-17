package com.ironhidegames.android.ironmari.ui.screens

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ironhidegames.android.ironmari.ui.components.ScreenBackground
import com.ironhidegames.android.ironmari.ui.theme.CyanAccent
import com.ironhidegames.android.ironmari.ui.theme.GoldAccent
import com.ironhidegames.android.ironmari.ui.theme.MidnightBlue
import com.ironhidegames.android.ironmari.ui.theme.RoyalBlue
import com.ironhidegames.android.ironmari.ui.theme.SkyAccent
import com.ironhidegames.android.ironmari.ui.theme.TextPrimary
import com.ironhidegames.android.ironmari.ui.theme.TextSecondary
import kotlinx.coroutines.delay
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

@Composable
fun LoadingScreen(onDone: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(2000L)
        onDone()
    }

    ScreenBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedGlobe(modifier = Modifier.size(220.dp))

            Spacer(Modifier.height(32.dp))

            Text(
                text = "Geo Brain",
                color = TextPrimary,
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Explore the world, one fact at a time",
                color = TextSecondary,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(40.dp))

            // Indeterminate progress bar
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(6.dp)
                    .clip(CircleShape),
                color = CyanAccent,
                trackColor = MidnightBlue
            )
        }
    }
}

@Composable
private fun AnimatedGlobe(modifier: Modifier = Modifier) {
    val transition = rememberInfiniteTransition(label = "globe")
    val rotation by transition.animateFloat(
        initialValue = 0f, targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(6000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "rotation"
    )
    val pulse by transition.animateFloat(
        initialValue = 0.9f, targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(1800, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse"
    )
    val markerBlink by transition.animateFloat(
        initialValue = 0.3f, targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "marker"
    )

    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val center = Offset(size.width / 2f, size.height / 2f)
            val radius = (size.minDimension / 2f) * 0.9f * pulse

            // Outer glow
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(CyanAccent.copy(alpha = 0.25f), Color.Transparent),
                    center = center,
                    radius = radius * 1.35f
                ),
                radius = radius * 1.35f,
                center = center
            )

            // Globe body
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        RoyalBlue.copy(alpha = 0.9f),
                        MidnightBlue,
                        MidnightBlue.copy(alpha = 0.2f)
                    ),
                    center = Offset(center.x - radius * 0.25f, center.y - radius * 0.25f),
                    radius = radius
                ),
                radius = radius,
                center = center
            )

            // Equator
            drawCircle(
                color = SkyAccent.copy(alpha = 0.6f),
                radius = radius,
                center = center,
                style = Stroke(width = 1.4f)
            )

            // Meridians (rotating)
            val meridianCount = 6
            for (i in 0 until meridianCount) {
                val angle = (i * 30f + rotation) % 180f
                val scaleX = abs(cos(Math.toRadians(angle.toDouble()))).toFloat()
                val ellipseWidth = radius * 2f * scaleX
                drawArc(
                    color = SkyAccent.copy(alpha = 0.35f),
                    startAngle = 0f,
                    sweepAngle = 360f,
                    useCenter = false,
                    topLeft = Offset(
                        center.x - ellipseWidth / 2f,
                        center.y - radius
                    ),
                    size = Size(ellipseWidth.coerceAtLeast(2f), radius * 2f),
                    style = Stroke(width = 1f)
                )
            }

            // Latitude rings
            for (lat in listOf(-0.6f, -0.3f, 0.3f, 0.6f)) {
                val y = center.y + radius * lat
                val w = radius * 2f * sqrt(1f - lat * lat)
                drawArc(
                    color = SkyAccent.copy(alpha = 0.2f),
                    startAngle = 0f,
                    sweepAngle = 360f,
                    useCenter = false,
                    topLeft = Offset(center.x - w / 2f, y - 6f),
                    size = Size(w, 12f),
                    style = Stroke(width = 1f)
                )
            }

            // Dashed orbit
            drawCircle(
                color = GoldAccent.copy(alpha = 0.55f),
                radius = radius * 1.18f,
                center = center,
                style = Stroke(
                    width = 1.4f,
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 14f))
                )
            )

            // Glowing markers (simulated cities) rotating around the globe
            val markers = listOf(
                Pair(45f, 0.55f),
                Pair(160f, 0.65f),
                Pair(250f, 0.5f),
                Pair(320f, 0.7f)
            )
            for ((baseAngle, rOffset) in markers) {
                val a = Math.toRadians((baseAngle + rotation).toDouble())
                val mx = center.x + cos(a).toFloat() * radius * rOffset
                val my = center.y + sin(a).toFloat() * radius * rOffset * 0.55f
                drawCircle(
                    color = GoldAccent.copy(alpha = markerBlink),
                    radius = 5f,
                    center = Offset(mx, my)
                )
                drawCircle(
                    color = GoldAccent.copy(alpha = 0.25f * markerBlink),
                    radius = 11f,
                    center = Offset(mx, my)
                )
            }
        }
    }
}
