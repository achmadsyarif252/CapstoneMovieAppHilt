package com.example.capstonemovieapp.core.domain.repository

import com.example.capstonemovieapp.core.data.Resource
import com.example.capstonemovieapp.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getAllPopularMovie(): Flow<Resource<List<Movie>>>
    fun getFavoriteMovie(): Flow<List<Movie>>
    fun setFavoriteMovie(movie: Movie, state: Boolean)
}