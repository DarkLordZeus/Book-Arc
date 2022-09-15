package com.example.bookarc.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = primaryNight,
    primaryVariant = textNight,
    secondary = Teal200,
    onSurface = cardNight,
    background = backgroundNight,

)

private val LightColorPalette = lightColors(
    primary = primary,
    primaryVariant = text,
    secondary = Teal200,
    onSurface = card,
    background = background

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun BookArcTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    val systemUiController = rememberSystemUiController()
    if(darkTheme){
        systemUiController.setSystemBarsColor(
            color = backgroundNight
        )
    }else{
        systemUiController.setSystemBarsColor(
            color = background
        )
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content,

    )
}