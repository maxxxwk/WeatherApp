package com.maxxxwk.weatherapp.screens.weather.data

import com.maxxxwk.weatherapp.screens.weather.ui.Weather
import javax.inject.Inject
import kotlin.math.roundToInt

class WeatherMapper @Inject constructor() {
    fun map(weatherResponse: WeatherResponse): Weather {
        return Weather(
            cityName = weatherResponse.cityName,
            weather = weatherResponse.weather.first().weather,
            weatherDescription = weatherResponse.weather.first().description,
            temperature = weatherResponse.temperature.value.roundToInt().toString(),
            countryCode = weatherResponse.country.value,
            iconURL = buildIconURL(weatherResponse.weather.first().icon)
        )
    }

    private fun buildIconURL(icon: String): String {
        return "https://openweathermap.org/img/wn/$icon@2x.png"
    }
}
