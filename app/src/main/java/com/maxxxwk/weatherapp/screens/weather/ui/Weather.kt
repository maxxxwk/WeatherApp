package com.maxxxwk.weatherapp.screens.weather.ui

data class Weather(
    val cityName: String,
    val weather: String,
    val weatherDescription: String,
    val temperature: String,
    val countryCode: String,
    val iconURL: String
)
