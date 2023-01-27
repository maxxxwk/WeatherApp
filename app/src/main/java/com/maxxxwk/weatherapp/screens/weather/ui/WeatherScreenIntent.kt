package com.maxxxwk.weatherapp.screens.weather.ui

import androidx.annotation.StringRes

sealed interface WeatherScreenIntent {
    data class LoadWeatherInfo(val city: String) : WeatherScreenIntent
    data class ShowWeatherInfo(val weather: Weather) : WeatherScreenIntent
    data class ShowError(@StringRes val errorMessage: Int) : WeatherScreenIntent
}
