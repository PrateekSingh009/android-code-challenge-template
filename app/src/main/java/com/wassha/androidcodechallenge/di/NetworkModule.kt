package com.wassha.androidcodechallenge.di

import com.wassha.androidcodechallenge.api.ApiService
import com.wassha.androidcodechallenge.dao.JokeDao
import com.wassha.androidcodechallenge.data.JokeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    val baseURL = "https://v2.jokeapi.dev/joke/"

    @Provides
    @Singleton
    fun provideApi() : ApiService {
        return Retrofit.Builder().baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}