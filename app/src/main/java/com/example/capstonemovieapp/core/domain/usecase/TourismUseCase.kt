package com.example.capstonemovieapp.core.domain.usecase

import androidx.lifecycle.LiveData
import com.example.capstonemovieapp.core.data.Resource
import com.example.capstonemovieapp.core.domain.model.Movie

interface MovieUseCase {
    fun getAllPopularMovie(): LiveData<Resource<List<Movie>>>
    fun getFavoriteMovie(): LiveData<List<Movie>>
    fun setFavoriteMovie(movie: Movie, state: Boolean)
}