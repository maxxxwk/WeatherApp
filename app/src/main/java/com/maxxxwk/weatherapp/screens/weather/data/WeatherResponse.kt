package com.maxxxwk.weatherapp.screens.weather.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    @SerialName("weather") val weather: List<WeatherInfo>,
    @SerialName("main") val temperature: Temperature,
    @SerialName("name") val cityName: String,
    @SerialName("sys") val country: Country
)

@Serializable
data class WeatherInfo(
    @SerialName("main") val weather: String,
    @SerialName("description") val description: String,
    @SerialName("icon") val icon: String
)

@Serializable
data class Temperature(
    @SerialName("temp") val value: Double
)

@Serializable
data class Country(
    @SerialName("country") val value: String
)
