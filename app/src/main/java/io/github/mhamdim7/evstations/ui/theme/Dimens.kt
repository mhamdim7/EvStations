package io.github.mhamdim7.evstations.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class Dimens(

    // Core spacing scale
    val space2: Dp = 2.dp,
    val space4: Dp = 4.dp,
    val space8: Dp = 8.dp,
    val space12: Dp = 12.dp,
    val space16: Dp = 16.dp,
    val space20: Dp = 20.dp,
    val space24: Dp = 24.dp,
    val space32: Dp = 32.dp,

    // Sizes
    val cardPadding: Dp = 16.dp,
    val sectionSpacing: Dp = 24.dp,
    val titleSpacing: Dp = 8.dp,

    // Components
    val cardCornerRadius: Dp = 12.dp,
    val buttonHeight: Dp = 48.dp,

    // Icons
    val iconSmall: Dp = 18.dp,
    val iconMedium: Dp = 24.dp,
    val iconLarge: Dp = 32.dp,
)

val MaterialTheme.dimens: Dimens
    get() = Dimens()
