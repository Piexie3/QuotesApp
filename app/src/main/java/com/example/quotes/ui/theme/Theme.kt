package com.example.quotes.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    background = background,
    onBackground = onBackground,
    secondary = secondary,
    onSecondary = onSecondary,

    )

private val LightColorPalette = darkColors(
    background = background,
    onBackground = onBackground,
    secondary = secondary,
    onSecondary = onSecondary,

    )

@Composable
fun QuotesTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}