package com.wassha.androidcodechallenge.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.*
import com.wassha.androidcodechallenge.data.Joke
import com.wassha.androidcodechallenge.data.JokeRepository
import dagger.hilt.android.internal.Contexts.getApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokeViewModel @Inject constructor(
    private val repository: JokeRepository
): ViewModel() {

    val joke = MutableLiveData<JokeUiModel>()
    val isLocal = MutableLiveData<Boolean>()

    init {
        joke.value = JokeUiModel.default()
    }

    fun getJoke() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getJoke(isLocal).let { joke.postValue(it?.toUiModel()) }
        }
    }
}

data class JokeUiModel (val joke: String) {
    companion object {
        fun default() = JokeUiModel("Empty")
    }
}

fun Joke.toUiModel() = JokeUiModel(joke = joke)

