package io.github.mhamdim7.evstations.data.network

import io.github.mhamdim7.evstations.data.models.StationRemoteDto
import retrofit2.http.GET

interface EvApi {
    @GET("stations.json")
    suspend fun getStations(): StationRemoteDto
}