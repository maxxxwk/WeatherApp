package com.maxxxwk.weatherapp

import android.app.Application
import android.content.Context
import com.maxxxwk.weatherapp.di.AppComponent
import com.maxxxwk.weatherapp.di.DaggerAppComponent

class App : Application() {
    val component: AppComponent by lazy {
        DaggerAppComponent.factory().create()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> component
        else -> applicationContext.appComponent
    }
