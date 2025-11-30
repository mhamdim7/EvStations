package io.github.mhamdim7.evstations.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StationRemoteDto(
    @SerialName("stations") val stations: List<Station>
)

@Serializable
data class Station(
    @SerialName("amenities") val amenities: List<String>,
    @SerialName("connectors") val connectors: List<Connector>,
    @SerialName("id") val id: String,
    @SerialName("lastUpdated") val lastUpdated: String,
    @SerialName("location") val location: Location,
    @SerialName("name") val name: String,
    @SerialName("operator") val `operator`: String,
    @SerialName("pricing") val pricing: Pricing,
    @SerialName("status") val status: String
)

@Serializable
data class Connector(
    @SerialName("powerKw") val powerKw: Double, @SerialName("type") val type: String
)

@Serializable
data class Location(
    @SerialName("address") val address: String,
    @SerialName("city") val city: String,
    @SerialName("country") val country: String,
    @SerialName("lat") val lat: Double,
    @SerialName("lng") val lng: Double
)

@Serializable
data class Pricing(
    @SerialName("currency") val currency: String,
    @SerialName("idleFeePerMinute") val idleFeePerMinute: Double,
    @SerialName("pricePerKwh") val pricePerKwh: Double
)
