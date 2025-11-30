package io.github.mhamdim7.evstations.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme

// ---------------------------------------------------------
// DARK THEME (Default)
// ---------------------------------------------------------
val DarkScheme = darkColorScheme(
    primary = BluePrimary,
    onPrimary = ColorWhite,

    secondary = BlueSecondary,
    onSecondary = ColorWhite,

    tertiary = TertiaryPurple,
    onTertiary = ColorWhite,

    background = DarkBackground,
    onBackground = ColorWhite,

    surface = DarkSurface,
    onSurface = ColorWhite,

    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = TextSecondary,

    error = ErrorRed,
    onError = ColorBlack,
    errorContainer = ErrorRedContainer,
    onErrorContainer = ColorWhite,

    outline = OutlineGray
)


// ---------------------------------------------------------
// LIGHT THEME
// ---------------------------------------------------------
val LightScheme = lightColorScheme(
    primary = BluePrimary,
    onPrimary = ColorWhite,

    secondary = BlueSecondary,
    onSecondary = ColorWhite,

    tertiary = TertiaryPurple,
    onTertiary = ColorWhite,

    background = LightBackground,
    onBackground = DarkBackground,

    surface = LightSurface,
    onSurface = DarkBackground,

    error = ErrorRed,
    onError = ColorWhite,
    errorContainer = ErrorRedContainer,
    onErrorContainer = ColorBlack,

    outline = OutlineGrayLight
)


// ---------------------------------------------------------
// NEON DARK THEME
// ---------------------------------------------------------
val NeonDarkScheme = darkColorScheme(
    primary = CyanAccent,
    onPrimary = ColorBlack,

    secondary = BlueSecondary,
    onSecondary = ColorWhite,

    tertiary = TertiaryPurple,
    onTertiary = ColorWhite,

    background = DarkBackground,
    onBackground = ColorWhite,

    surface = DarkSurfaceVariant,
    onSurface = ColorWhite,

    error = ErrorRed,
    onError = ColorBlack,
    errorContainer = ErrorRedContainer,
    onErrorContainer = ColorWhite,

    outline = OutlineGray
)


// ---------------------------------------------------------
// NEON LIGHT THEME
// ---------------------------------------------------------
val NeonLightScheme = lightColorScheme(
    primary = CyanAccent,
    onPrimary = ColorBlack,

    secondary = BlueSecondary,
    onSecondary = ColorWhite,

    tertiary = TertiaryPurple,
    onTertiary = ColorWhite,

    background = LightBackground,
    onBackground = DarkBackground,

    surface = LightSurface,
    onSurface = DarkBackground,

    error = ErrorRed,
    onError = ColorWhite,
    errorContainer = ErrorRedContainer,
    onErrorContainer = ColorBlack,

    outline = OutlineGrayLight
)
