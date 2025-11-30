package io.github.mhamdim7.evstations.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import io.github.mhamdim7.evstations.ui.navigation.AppDestination
import io.github.mhamdim7.evstations.ui.screens.MapScreen
import io.github.mhamdim7.evstations.ui.screens.ProfileScreen
import io.github.mhamdim7.evstations.ui.screens.StationsScreen
import io.github.mhamdim7.evstations.ui.theme.ColorMode
import io.github.mhamdim7.evstations.ui.theme.EvStationsTheme
import io.github.mhamdim7.evstations.ui.theme.ThemeMode
import io.github.mhamdim7.evstations.ui.theme.dimens

@Composable
fun EvStationsApp(
    appStateVm: AppViewModel
) {
    val dimens = MaterialTheme.dimens
    val currentDestination = appStateVm.currentDestination

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestination.entries.forEach { destination ->
                item(
                    icon = {
                        Icon(
                            imageVector = destination.icon,
                            contentDescription = destination.label
                        )
                    },
                    label = { Text(destination.label) },
                    selected = destination == currentDestination,
                    onClick = { appStateVm.navigateTo(destination) }
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = dimens.space16,
                    vertical = dimens.space12
                )
        ) {
            // ───────── Top bar: title + subtitle + settings ─────────
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimens.space24),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = currentDestination.label,
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    Spacer(modifier = Modifier.height(dimens.space4))

                    Text(
                        text = currentDestination.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                IconButton(onClick = { appStateVm.openSettings() }) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Appearance settings",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }

            Spacer(modifier = Modifier.height(dimens.space16))

            // ───────── Content for current destination ─────────
            when (currentDestination) {
                AppDestination.STATIONS -> StationsScreen()
                AppDestination.MAP -> MapScreen()
                AppDestination.PROFILE -> ProfileScreen()
            }
        }

        if (appStateVm.showSettings) {
            ThemeSettingsDialog(
                themeMode = appStateVm.themeMode,
                onThemeModeChange = { appStateVm.updateThemeMode(it) },
                colorMode = appStateVm.colorMode,
                onColorModeChange = { appStateVm.updateColorMode(it) },
                onDismiss = { appStateVm.closeSettings() }
            )
        }
    }
}

@Composable
private fun ThemeSettingsDialog(
    themeMode: ThemeMode,
    onThemeModeChange: (ThemeMode) -> Unit,
    colorMode: ColorMode,
    onColorModeChange: (ColorMode) -> Unit,
    onDismiss: () -> Unit
) {
    val dimens = MaterialTheme.dimens

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Close")
            }
        },
        title = {
            Text(
                text = "Appearance",
                style = MaterialTheme.typography.titleLarge
            )
        },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(dimens.space16)
            ) {
                // Theme mode section
                Column(
                    verticalArrangement = Arrangement.spacedBy(dimens.space8)
                ) {
                    Text(
                        text = "Theme mode",
                        style = MaterialTheme.typography.titleMedium
                    )
                    FullWidthSegmentedControl(
                        options = listOf(
                            ThemeMode.System,
                            ThemeMode.Light,
                            ThemeMode.Dark
                        ),
                        selected = themeMode,
                        labelFor = {
                            when (it) {
                                ThemeMode.System -> "System"
                                ThemeMode.Light -> "Light"
                                ThemeMode.Dark -> "Dark"
                            }
                        },
                        onOptionSelected = onThemeModeChange
                    )
                }

                // Color mode section
                Column(
                    verticalArrangement = Arrangement.spacedBy(dimens.space8)
                ) {
                    Text(
                        text = "Color mode",
                        style = MaterialTheme.typography.titleMedium
                    )
                    FullWidthSegmentedControl(
                        options = listOf(
                            ColorMode.Default,
                            ColorMode.Neon,
                            ColorMode.Dynamic
                        ),
                        selected = colorMode,
                        labelFor = {
                            when (it) {
                                ColorMode.Default -> "Normal"
                                ColorMode.Neon -> "Neon"
                                ColorMode.Dynamic -> "Dynamic"
                            }
                        },
                        onOptionSelected = onColorModeChange
                    )

                    // TODO: On devices below Android 12, hide "Dynamic" or
                    //       fallback to a 2-option switch (Normal / Neon).
                    Text(
                        text = "TODO: For devices below Android 12, adjust this to only show Normal / Neon.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    )
}

@Composable
private fun <T> FullWidthSegmentedControl(
    options: List<T>,
    selected: T,
    labelFor: (T) -> String,
    onOptionSelected: (T) -> Unit,
    modifier: Modifier = Modifier
) {
    val dimens = MaterialTheme.dimens

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp),
        horizontalArrangement = Arrangement.spacedBy(dimens.space4)
    ) {
        options.forEach { option ->
            val isSelected = option == selected

            Surface(
                modifier = Modifier.weight(1f),
                shape = MaterialTheme.shapes.small,
                color = if (isSelected) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.surfaceVariant
                },
                contentColor = if (isSelected) {
                    MaterialTheme.colorScheme.onPrimary
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                },
                onClick = { onOptionSelected(option) }
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = labelFor(option),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@PreviewScreenSizes
@Composable
fun EvStationsPreview() {
    // Preview-only instance; Hilt isn’t involved here
    val previewVm = AppViewModel()

    EvStationsTheme(
        themeMode = ThemeMode.System,
        colorMode = ColorMode.Default
    ) {
        EvStationsApp(appStateVm = previewVm)
    }
}