package com.wassha.androidcodechallenge.api

import com.wassha.androidcodechallenge.data.Joke
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("Programming")
    suspend fun getJoke(
        @Query("type") type : String = "single"
    ) : Response<Joke>
}