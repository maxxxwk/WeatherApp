package com.maxxxwk.weatherapp.screens.weather.ui

import androidx.lifecycle.viewModelScope
import com.maxxxwk.weatherapp.R
import com.maxxxwk.weatherapp.common.text.UIText
import com.maxxxwk.weatherapp.common.viewmodel.BaseViewModel
import com.maxxxwk.weatherapp.screens.weather.data.WeatherRepository
import javax.inject.Inject
import kotlinx.coroutines.launch


class WeatherScreenViewModel @Inject constructor(
    private val repository: WeatherRepository
) : BaseViewModel<WeatherScreenState, WeatherScreenIntent>(WeatherScreenState.Loading) {
    override fun reduce(intent: WeatherScreenIntent): WeatherScreenState {
        return when (intent) {
            is WeatherScreenIntent.LoadWeatherInfo -> {
                loadWeatherInfo(intent.city)
                WeatherScreenState.Loading
            }
            is WeatherScreenIntent.ShowError -> {
                WeatherScreenState.Error(UIText.StringResource(intent.errorMessage))
            }
            is WeatherScreenIntent.ShowWeatherInfo -> {
                WeatherScreenState.Content(intent.weather)
            }
        }
    }

    private fun loadWeatherInfo(city: String) = viewModelScope.launch {
        repository.getWeather(city).getOrNull()?.let {
            sendIntent(WeatherScreenIntent.ShowWeatherInfo(it))
        } ?: sendIntent(
            WeatherScreenIntent.ShowError(R.string.weather_info_loading_error)
        )
    }
}
