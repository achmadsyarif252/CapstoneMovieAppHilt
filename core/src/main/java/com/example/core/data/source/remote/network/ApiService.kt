package com.example.core.data.source.remote.network

import com.example.core.data.source.remote.response.ListMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    suspend fun getList(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int,
    ): ListMovieResponse
}