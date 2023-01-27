package com.maxxxwk.weatherapp.screens.search.ui

import com.maxxxwk.weatherapp.common.text.UIText
import com.maxxxwk.weatherapp.common.viewmodel.BaseViewModel
import javax.inject.Inject

class SearchScreenViewModel @Inject constructor() :
    BaseViewModel<SearchScreenState, SearchScreenIntent>(SearchScreenState(UIText.DynamicText(""))) {
    override fun reduce(intent: SearchScreenIntent): SearchScreenState {
        return when (intent) {
            is SearchScreenIntent.EnterSearchQueryText -> SearchScreenState(
                UIText.DynamicText(
                    intent.value
                )
            )
        }
    }

    fun enterSearchQueryText(value: String) {
        sendIntent(SearchScreenIntent.EnterSearchQueryText(value))
    }
}
