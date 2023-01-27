package com.maxxxwk.weatherapp.screens.weather.ui

import com.maxxxwk.weatherapp.common.text.UIText

sealed interface WeatherScreenState {
    object Loading : WeatherScreenState
    data class Error(val errorMessage: UIText) : WeatherScreenState
    data class Content(val weather: Weather) : WeatherScreenState
}
