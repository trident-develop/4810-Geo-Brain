package com.ironhidegames.android.ironmari.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val GeoDarkColorScheme = darkColorScheme(
    primary = SkyAccent,
    onPrimary = DeepNavy,
    primaryContainer = RoyalBlue,
    onPrimaryContainer = TextPrimary,
    secondary = CyanAccent,
    onSecondary = DeepNavy,
    secondaryContainer = DarkBlue,
    onSecondaryContainer = TextPrimary,
    tertiary = GoldAccent,
    onTertiary = DeepNavy,
    background = DeepNavy,
    onBackground = TextPrimary,
    surface = SurfaceBlue,
    onSurface = TextPrimary,
    surfaceVariant = CardBlue,
    onSurfaceVariant = TextSecondary,
    outline = Divider,
    error = ErrorRed,
    onError = Color.White
)

@Composable
fun GeoBrainTheme(content: @Composable () -> Unit) {
    val colorScheme = GeoDarkColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.Transparent.toArgb()
            window.navigationBarColor = Color.Transparent.toArgb()
            val controller = WindowCompat.getInsetsController(window, view)
            controller.isAppearanceLightStatusBars = false
            controller.isAppearanceLightNavigationBars = false
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                window.isStatusBarContrastEnforced = false
                window.isNavigationBarContrastEnforced = false
            }
        }
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
