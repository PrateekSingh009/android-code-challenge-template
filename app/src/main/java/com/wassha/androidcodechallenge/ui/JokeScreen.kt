package com.wassha.androidcodechallenge.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun JokeScreen(
    viewModel: JokeViewModel
) {

    val joke: JokeUiModel by viewModel.joke.observeAsState(JokeUiModel.default())
    val isLocal : Boolean by viewModel.isLocal.observeAsState(false)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = Alignment.CenterVertically
        )
    ) {

        Text(
            text = "Joke",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = joke.joke,
            style = MaterialTheme.typography.bodyLarge
        )

        joke.joke.length.let{
            if(it > 80){
                Text(
                    text = "Length: $it",
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }

        Text(
            text = "Words: ${joke.joke.split("\\s+".toRegex())
                .filter { it.isNotEmpty() }
                .count()}",
            style = MaterialTheme.typography.bodySmall,
        )

        val str = if(isLocal) "local" else "api"

        Text(
            text = "Data was fetched from $str",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Red
        )

        Button(onClick = { viewModel.getJoke()}) {
            Text(text = "Fetch Joke")
        }
    }
}

