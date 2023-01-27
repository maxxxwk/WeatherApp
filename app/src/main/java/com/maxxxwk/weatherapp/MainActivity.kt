package com.maxxxwk.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maxxxwk.weatherapp.common.viewmodel.ViewModelFactory
import com.maxxxwk.weatherapp.navigation.NavigationRoute
import com.maxxxwk.weatherapp.screens.search.ui.SearchScreen
import com.maxxxwk.weatherapp.screens.weather.ui.WeatherScreen
import com.maxxxwk.weatherapp.screens.weather.ui.WeatherScreenIntent
import com.maxxxwk.weatherapp.screens.weather.ui.WeatherScreenViewModel
import com.maxxxwk.weatherapp.ui.theme.WeatherAppTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        setContent {
            WeatherAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = NavigationRoute.SearchScreen.route
                    ) {
                        composable(NavigationRoute.SearchScreen.route) {
                            SearchScreen(viewModel(factory = viewModelFactory)) {
                                navController.navigate(NavigationRoute.WeatherScreen.passArgument(it))
                            }
                        }
                        composable(
                            NavigationRoute.WeatherScreen.route,
                            NavigationRoute.WeatherScreen.args
                        ) { backStackEntry ->
                            backStackEntry.arguments
                                ?.getString(NavigationRoute.CITY_NAME_ARGUMENT)?.let {
                                    val viewModel: WeatherScreenViewModel =
                                        viewModel(factory = viewModelFactory)

                                    LaunchedEffect(Unit) {
                                        viewModel.sendIntent(WeatherScreenIntent.LoadWeatherInfo(it))
                                    }

                                    WeatherScreen(
                                        viewModel = viewModel,
                                        back = navController::popBackStack
                                    )
                                }
                        }
                    }
                }
            }
        }
    }
}
