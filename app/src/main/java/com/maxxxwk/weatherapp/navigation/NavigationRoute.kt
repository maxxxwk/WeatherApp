package com.maxxxwk.weatherapp.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavigationRoute(val route: String) {
    object SearchScreen : NavigationRoute("search")

    object WeatherScreen : NavigationRoute("weather/{$CITY_NAME_ARGUMENT}") {
        val args = listOf(
            navArgument(CITY_NAME_ARGUMENT) {
                type = NavType.StringType
            }
        )

        fun passArgument(city: String): String {
            return route.replace("{$CITY_NAME_ARGUMENT}", city)
        }
    }

    companion object {
        const val CITY_NAME_ARGUMENT = "city"
    }
}
