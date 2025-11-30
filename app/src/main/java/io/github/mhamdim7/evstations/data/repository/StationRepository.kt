package io.github.mhamdim7.evstations.data.repository

import io.github.mhamdim7.evstations.data.models.Station
import io.github.mhamdim7.evstations.data.network.EvApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StationRepository @Inject constructor(
    private val api: EvApi
) {
    suspend fun fetchStations(): List<Station> {
        return api.getStations().stations
    }

    suspend fun fetchStationById(id: String): Station? {
        return fetchStations().firstOrNull { it.id == id }
    }
}