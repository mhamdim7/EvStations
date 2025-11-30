package io.github.mhamdim7.evstations.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.EvStation
import androidx.compose.material.icons.filled.Map
import androidx.compose.ui.graphics.vector.ImageVector

enum class AppDestination(
    val label: String,
    val description: String,
    val icon: ImageVector,
) {
    STATIONS("Stations List", "Nearby Stations", Icons.Default.EvStation),
    MAP("Stations Map", "Nearby Stations", Icons.Default.Map),
    PROFILE(
        "Profile",
        "Profile Settings & preferences will appear here.",
        Icons.Default.AccountBox
    ),
}