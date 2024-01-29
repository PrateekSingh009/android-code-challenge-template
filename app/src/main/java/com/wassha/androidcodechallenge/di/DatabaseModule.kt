package com.wassha.androidcodechallenge.di

import android.content.Context
import androidx.room.Room
import com.wassha.androidcodechallenge.dao.JokeDao
import com.wassha.androidcodechallenge.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context) : AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "JOKE_DATABASE"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideJokeDao(appDatabase : AppDatabase) : JokeDao {
        return appDatabase.jokeDao
    }
}