package com.example.capstonemovieapp.core.data.source.remote.network

import com.example.capstonemovieapp.core.data.source.remote.response.ListMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getList(@Query("api_key") apiKey: String): Call<ListMovieResponse>
}