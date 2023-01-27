package com.maxxxwk.weatherapp.screens.weather.data

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") cityName: String,
        @Query("units") units: String = "metric"
    ): WeatherResponse
}
