package com.wassha.androidcodechallenge.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wassha.androidcodechallenge.dao.JokeDao
import com.wassha.androidcodechallenge.data.JokeEntity

@Database(entities = [JokeEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val jokeDao : JokeDao
}