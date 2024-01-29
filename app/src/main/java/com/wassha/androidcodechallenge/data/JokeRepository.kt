package com.wassha.androidcodechallenge.data

import androidx.lifecycle.MutableLiveData
import com.wassha.androidcodechallenge.api.ApiService
import com.wassha.androidcodechallenge.dao.JokeDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class JokeRepository @Inject constructor(val dao: JokeDao, val apiService: ApiService) {

    suspend fun getJoke(isLocal: MutableLiveData<Boolean>) : Joke? {
        var joke : Joke?
        try {
            joke = apiService.getJoke().body()
            insertJokeInDB(convertApiModelToDbModel(joke))
            isLocal.postValue(false)
        } catch (e : Exception) {
            joke = convertDbModelToApiModel(dao.pickRandomJoke())
            isLocal.postValue(true)
        }
        return joke
    }

    fun insertJokeInDB(jokeEntity: JokeEntity?) {
        runBlocking(Dispatchers.IO) {
            jokeEntity?.let{
                dao.upsertJoke(jokeEntity)
            }
        }

    }

    private fun convertApiModelToDbModel(joke: Joke?) : JokeEntity? {
        val jokeEntity =  joke?.let{
            JokeEntity(joke.id,joke.joke,joke.category,joke.type)
        } ?: null
        return jokeEntity
    }

    private fun convertDbModelToApiModel(jokeEntity: JokeEntity?) : Joke? {
        val joke =  jokeEntity?.let{
            Joke(jokeEntity.joke,jokeEntity.id,jokeEntity.category,jokeEntity.type)
        } ?: null
        return joke
    }
}

