package com.maxxxwk.weatherapp.common.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

abstract class BaseViewModel<STATE, INTENT>(initialState: STATE) : ViewModel() {

    private val intents = MutableSharedFlow<INTENT>(replay = 1)
    val state: StateFlow<STATE> = intents
        .map(::reduce)
        .stateIn(viewModelScope, SharingStarted.Lazily, initialState)

    protected abstract fun reduce(intent: INTENT): STATE

    fun sendIntent(intent: INTENT) = viewModelScope.launch {
        intents.emit(intent)
    }
}
