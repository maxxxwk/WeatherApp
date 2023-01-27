package com.maxxxwk.weatherapp.di

import com.maxxxwk.weatherapp.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, NetworkModule::class, ViewModelModule::class])
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }
}
