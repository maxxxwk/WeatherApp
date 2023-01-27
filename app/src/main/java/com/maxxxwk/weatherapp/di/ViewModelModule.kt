package com.maxxxwk.weatherapp.di

import androidx.lifecycle.ViewModel
import com.maxxxwk.weatherapp.common.viewmodel.ViewModelKey
import com.maxxxwk.weatherapp.screens.search.ui.SearchScreenViewModel
import com.maxxxwk.weatherapp.screens.weather.ui.WeatherScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @IntoMap
    @ViewModelKey(WeatherScreenViewModel::class)
    @Binds
    fun bindWeatherScreenViewModel(weatherScreenViewModel: WeatherScreenViewModel): ViewModel

    @IntoMap
    @ViewModelKey(SearchScreenViewModel::class)
    @Binds
    fun bindSearchScreenViewModel(searchScreenViewModel: SearchScreenViewModel): ViewModel
}
