package com.ironhidegames.android.ironmari.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ironhidegames.android.ironmari.R

val AppFont = FontFamily(
    Font(R.font.font, FontWeight.Normal),
    Font(R.font.font, FontWeight.Medium),
    Font(R.font.font, FontWeight.SemiBold),
    Font(R.font.font, FontWeight.Bold)
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = AppFont, fontWeight = FontWeight.Bold,
        fontSize = 34.sp, lineHeight = 40.sp, letterSpacing = 0.sp
    ),
    displayMedium = TextStyle(
        fontFamily = AppFont, fontWeight = FontWeight.Bold,
        fontSize = 28.sp, lineHeight = 34.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = AppFont, fontWeight = FontWeight.Bold,
        fontSize = 26.sp, lineHeight = 32.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = AppFont, fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp, lineHeight = 28.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = AppFont, fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp, lineHeight = 26.sp
    ),
    titleLarge = TextStyle(
        fontFamily = AppFont, fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp, lineHeight = 24.sp
    ),
    titleMedium = TextStyle(
        fontFamily = AppFont, fontWeight = FontWeight.Medium,
        fontSize = 16.sp, lineHeight = 22.sp
    ),
    titleSmall = TextStyle(
        fontFamily = AppFont, fontWeight = FontWeight.Medium,
        fontSize = 14.sp, lineHeight = 20.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = AppFont, fontWeight = FontWeight.Normal,
        fontSize = 16.sp, lineHeight = 24.sp, letterSpacing = 0.3.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = AppFont, fontWeight = FontWeight.Normal,
        fontSize = 14.sp, lineHeight = 20.sp
    ),
    bodySmall = TextStyle(
        fontFamily = AppFont, fontWeight = FontWeight.Normal,
        fontSize = 12.sp, lineHeight = 18.sp
    ),
    labelLarge = TextStyle(
        fontFamily = AppFont, fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.5.sp
    ),
    labelMedium = TextStyle(
        fontFamily = AppFont, fontWeight = FontWeight.Medium,
        fontSize = 12.sp, lineHeight = 16.sp
    ),
    labelSmall = TextStyle(
        fontFamily = AppFont, fontWeight = FontWeight.Medium,
        fontSize = 11.sp, lineHeight = 14.sp
    )
)
