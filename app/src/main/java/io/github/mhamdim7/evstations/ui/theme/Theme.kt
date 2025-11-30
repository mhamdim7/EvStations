package io.github.mhamdim7.evstations.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext

enum class ThemeMode {
    System, Light, Dark
}

enum class ColorMode {
    Default, Dynamic, Neon
}

@Composable
fun EvStationsTheme(
    themeMode: ThemeMode = ThemeMode.System,
    colorMode: ColorMode = ColorMode.Default,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current

    val dark = when (themeMode) {
        ThemeMode.Dark -> true
        ThemeMode.Light -> false
        ThemeMode.System -> isSystemInDarkTheme()
    }

    val colorScheme = when (colorMode) {
        ColorMode.Neon -> {
            if (dark) NeonDarkScheme else NeonLightScheme
        }

        ColorMode.Dynamic -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                if (dark) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            } else {
                if (dark) DarkScheme else LightScheme
            }
        }

        ColorMode.Default -> {
            if (dark) DarkScheme else LightScheme
        }
    }

    val isNeon = colorMode == ColorMode.Neon

    CompositionLocalProvider(
        LocalNeonMode provides isNeon
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

private val LocalNeonMode = staticCompositionLocalOf { false }

val MaterialTheme.isNeonThemeActive: Boolean
    @Composable
    get() = LocalNeonMode.current