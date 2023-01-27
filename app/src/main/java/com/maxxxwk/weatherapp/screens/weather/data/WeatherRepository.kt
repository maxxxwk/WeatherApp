package com.maxxxwk.weatherapp.screens.weather.data

import com.maxxxwk.weatherapp.di.qualifiers.DispatcherIO
import com.maxxxwk.weatherapp.screens.weather.ui.Weather
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

@Singleton
class WeatherRepository @Inject constructor(
    @DispatcherIO private val dispatcher: CoroutineDispatcher,
    private val weatherService: WeatherService,
    private val weatherMapper: WeatherMapper
) {
    suspend fun getWeather(q: String): Result<Weather> = withContext(dispatcher) {
        try {
            Result.success(weatherMapper.map(weatherService.getWeather(cityName = q)))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
