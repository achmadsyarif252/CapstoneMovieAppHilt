package com.example.capstonemovieapp.core.domain.repository

import androidx.lifecycle.LiveData
import com.example.capstonemovieapp.core.data.Resource
import com.example.capstonemovieapp.core.domain.model.Movie
import io.reactivex.Flowable

interface IMovieRepository {
    fun getAllPopularMovie(): Flowable<Resource<List<Movie>>>
    fun getFavoriteMovie(): Flowable<List<Movie>>
    fun setFavoriteMovie(movie: Movie, state: Boolean)
}