package com.wassha.androidcodechallenge.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Upsert
import com.wassha.androidcodechallenge.data.JokeEntity
import retrofit2.http.GET
import androidx.room.Query

@Dao
interface JokeDao {

    @Upsert
    fun upsertJoke(joke : JokeEntity)

    @Delete
    fun deleteJoke(joke : JokeEntity)

    @Query("SELECT * FROM Jokes ORDER BY RANDOM() LIMIT 1")
    fun pickRandomJoke() : JokeEntity
}