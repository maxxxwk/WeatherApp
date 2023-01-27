package com.maxxxwk.weatherapp.di

import com.maxxxwk.weatherapp.di.qualifiers.DispatcherDefault
import com.maxxxwk.weatherapp.di.qualifiers.DispatcherIO
import com.maxxxwk.weatherapp.di.qualifiers.DispatcherMain
import com.maxxxwk.weatherapp.di.qualifiers.DispatcherUnconfined
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class AppModule {
    @Provides
    @DispatcherMain
    fun provideDispatcherMain(): CoroutineDispatcher = Dispatchers.Main

    @Provides
    @DispatcherIO
    fun provideDispatcherIO(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @DispatcherDefault
    fun provideDispatcherDefault(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    @DispatcherUnconfined
    fun provideDispatchersUnconfined(): CoroutineDispatcher = Dispatchers.Unconfined
}
