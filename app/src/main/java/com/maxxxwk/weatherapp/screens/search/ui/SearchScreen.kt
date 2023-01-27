package com.maxxxwk.weatherapp.screens.search.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.maxxxwk.weatherapp.R

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchScreen(viewModel: SearchScreenViewModel, showWeatherInfo: (String) -> Unit = {}) {
    val state by viewModel.state.collectAsState()

    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 4.dp,
                title = {
                    Text(text = stringResource(R.string.app_name))
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
            OutlinedTextField(
                modifier = Modifier
                    .width(320.dp)
                    .padding(8.dp)
                    .clip(MaterialTheme.shapes.small),
                value = state.searchFieldValue.asString(),
                onValueChange = viewModel::enterSearchQueryText,
                singleLine = true,
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = null)
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        showWeatherInfo(state.searchFieldValue.asString(context))
                        focusManager.clearFocus()
                        keyboardController?.hide()
                    }
                ),
                textStyle = MaterialTheme.typography.h5,
                label = {
                    Text(text = stringResource(R.string.search_field_label_text))
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier.clip(MaterialTheme.shapes.large),
                onClick = {
                    showWeatherInfo(state.searchFieldValue.asString(context))
                    focusManager.clearFocus()
                    keyboardController?.hide()
                }
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        text = stringResource(R.string.show_weather_button_text)
                    )
                    Icon(imageVector = Icons.Filled.Search, contentDescription = null)
                }
            }
        }
    }
}
