package com.maxxxwk.weatherapp.screens.weather.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.maxxxwk.weatherapp.R
import com.maxxxwk.weatherapp.common.text.UIText

@Composable
fun WeatherScreen(viewModel: WeatherScreenViewModel, back: () -> Unit = {}) {

    val state by viewModel.state.collectAsState()

    when (state) {
        is WeatherScreenState.Content -> WeatherScreenContent(
            weather = (state as WeatherScreenState.Content).weather,
            back = back
        )
        is WeatherScreenState.Error -> WeatherScreenError(
            errorMessage = (state as WeatherScreenState.Error).errorMessage
        )
        WeatherScreenState.Loading -> WeatherScreenLoading()
    }
}

@Composable
private fun WeatherScreenContent(weather: Weather, back: () -> Unit = {}) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                elevation = 4.dp,
                navigationIcon = {
                    IconButton(onClick = back) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                },
                title = {
                    Text(
                        text = "${weather.cityName}(${weather.countryCode})",
                        style = MaterialTheme.typography.subtitle2
                    )
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = weather.weather, style = MaterialTheme.typography.h4)
            Row(verticalAlignment = Alignment.CenterVertically) {
                AsyncImage(
                    modifier = Modifier.size(120.dp),
                    model = weather.iconURL,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    text = "${weather.temperature}°",
                    style = MaterialTheme.typography.h2
                )
            }
            Text(text = weather.weatherDescription, style = MaterialTheme.typography.h5)
        }
    }
}

@Composable
private fun WeatherScreenError(errorMessage: UIText) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_error),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = errorMessage.asString(),
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.error,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun WeatherScreenLoading() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator()
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.loading_label),
            style = MaterialTheme.typography.h4
        )
    }
}
