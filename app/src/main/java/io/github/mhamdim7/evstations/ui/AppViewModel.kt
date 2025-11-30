package io.github.mhamdim7.evstations.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.mhamdim7.evstations.ui.navigation.AppDestination
import io.github.mhamdim7.evstations.ui.theme.ColorMode
import io.github.mhamdim7.evstations.ui.theme.ThemeMode
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor() : ViewModel() {

    // Navigation
    var currentDestination by mutableStateOf(AppDestination.STATIONS)
        private set

    fun navigateTo(dest: AppDestination) {
        currentDestination = dest
    }

    // Theme mode (System / Light / Dark)
    var themeMode by mutableStateOf(ThemeMode.System)
        private set

    fun updateThemeMode(mode: ThemeMode) {
        themeMode = mode
    }

    // Color mode (Default / Neon / Dynamic)
    var colorMode by mutableStateOf(ColorMode.Default)
        private set

    fun updateColorMode(mode: ColorMode) {
        colorMode = mode
    }

    // Settings dialog visibility
    var showSettings by mutableStateOf(false)
        private set

    fun openSettings() {
        showSettings = true
    }

    fun closeSettings() {
        showSettings = false
    }
}