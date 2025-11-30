package io.github.mhamdim7.evstations.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import io.github.mhamdim7.evstations.data.models.Station
import io.github.mhamdim7.evstations.ui.components.ErrorState
import io.github.mhamdim7.evstations.ui.components.LoadingState
import io.github.mhamdim7.evstations.ui.theme.dimens

@Composable
fun StationsScreen(
    modifier: Modifier = Modifier,
    viewModel: StationsViewModel = hiltViewModel(),
    onStationClick: (Station) -> Unit = {}
) {
    val dimens = MaterialTheme.dimens

    val uiState by viewModel.stationsUiState.collectAsState()

    when (uiState) {
        StationsUiState.Loading -> LoadingState()
        is StationsUiState.Error -> ErrorState { viewModel.load() }
        is StationsUiState.Success -> LazyColumn(
            verticalArrangement = Arrangement.spacedBy(dimens.space12),
            modifier = Modifier.fillMaxSize()
        ) {
            items((uiState as StationsUiState.Success).stations) { station ->
                StationCard(
                    station = station,
                    onClick = { onStationClick(station) }
                )
            }
        }
    }
}

@Composable
fun StationCard(
    station: Station,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val dimens = MaterialTheme.dimens

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier.padding(dimens.cardPadding)
        ) {
            Text(
                text = station.name,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(dimens.space4))
            Text(
                text = station.location.city, // or "${station.location.city} · ${station.operator}"
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}