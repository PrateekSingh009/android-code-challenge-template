package com.wassha.androidcodechallenge.di

import com.wassha.androidcodechallenge.api.ApiService
import com.wassha.androidcodechallenge.dao.JokeDao
import com.wassha.androidcodechallenge.data.JokeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(jokeDao: JokeDao, api : ApiService) : JokeRepository {
        return JokeRepository(jokeDao,api)
    }
}