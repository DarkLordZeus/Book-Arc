package com.example.bookarc.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.bookarc.R

// Set of Material typography styles to start with


val spacegrotesk = FontFamily(
    Font(R.font.spacegrotesk_bold,FontWeight.Bold),
    Font(R.font.spacegrotesk_light,FontWeight.Light),
    Font(R.font.spacegrotesk_medium,FontWeight.Medium),
    Font(R.font.spacegrotesk_regular,FontWeight.Normal)
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)