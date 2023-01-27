package com.maxxxwk.weatherapp.screens.search.ui

sealed interface SearchScreenIntent {
    data class EnterSearchQueryText(val value: String) : SearchScreenIntent
}
