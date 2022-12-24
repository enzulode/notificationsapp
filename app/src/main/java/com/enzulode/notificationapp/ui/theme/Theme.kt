package com.enzulode.notificationapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
	primary = White,
	secondary = Gray,
	background = Black
)

private val LightColorPalette = lightColors(
	primary = White,
	secondary = Gray,
	background = Black

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
fun NotificationAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit)
{
//	val colors = if (darkTheme)
//	{
//		DarkColorPalette
//	} else
//	{
//		LightColorPalette
//	}

	val colors = DarkColorPalette

	MaterialTheme(
		colors = colors,
		typography = Typography,
		shapes = Shapes,
		content = content
	)
}