package io.github.mhamdim7.evstations.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.mhamdim7.evstations.data.models.Station
import io.github.mhamdim7.evstations.data.repository.StationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class StationsUiState {
    data class Success(val stations: List<Station> = listOf()) : StationsUiState()
    data class Error(val errorMessage: String? = null) : StationsUiState()
    object Loading : StationsUiState()
}

@HiltViewModel
class StationsViewModel @Inject constructor(
    private val repository: StationRepository
) : ViewModel() {


    private val _stationsUiState = MutableStateFlow<StationsUiState>(StationsUiState.Loading)
    val stationsUiState = _stationsUiState.asStateFlow()

    init {
        load()
    }

    fun load() = viewModelScope.launch {
        _stationsUiState.value = StationsUiState.Loading

        _stationsUiState.value = runCatching {
            repository.fetchStations()
        }.fold(
            onSuccess = { stations ->
                StationsUiState.Success(stations)
            },
            onFailure = { throwable ->
                StationsUiState.Error(throwable.message)
            }
        )
    }
}