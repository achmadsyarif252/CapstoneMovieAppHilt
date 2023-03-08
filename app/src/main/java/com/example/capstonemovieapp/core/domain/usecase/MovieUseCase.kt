package com.example.capstonemovieapp.core.domain.usecase

import com.example.capstonemovieapp.core.data.Resource
import com.example.capstonemovieapp.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getAllPopularMovie(): Flow<Resource<List<Movie>>>
    fun getFavoriteMovie(): Flow<List<Movie>>
    fun setFavoriteMovie(movie: Movie, state: Boolean)
}