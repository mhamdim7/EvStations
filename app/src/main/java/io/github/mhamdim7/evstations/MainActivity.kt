package io.github.mhamdim7.evstations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.github.mhamdim7.evstations.ui.AppViewModel
import io.github.mhamdim7.evstations.ui.EvStationsApp
import io.github.mhamdim7.evstations.ui.theme.EvStationsTheme


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val appViewModel: AppViewModel = hiltViewModel()

            EvStationsTheme(
                themeMode = appViewModel.themeMode,
                colorMode = appViewModel.colorMode
            ) {
                EvStationsApp(appStateVm = appViewModel)
            }
        }
    }
}
