package io.github.mhamdim7.evstations.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.mhamdim7.evstations.ui.theme.dimens

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    val dimens = MaterialTheme.dimens

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = dimens.space16, vertical = dimens.space24),
        verticalArrangement = Arrangement.spacedBy(dimens.sectionSpacing)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(dimens.space8)) {
            Text(
                text = "App info",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = "EV Stations demo\nData: GitHub mock JSON",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}