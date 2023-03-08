package com.example.capstonemovieapp.core.domain.usecase

import androidx.lifecycle.LiveData
import com.example.capstonemovieapp.core.data.Resource
import com.example.capstonemovieapp.core.domain.model.Movie
import io.reactivex.Flowable

interface MovieUseCase {
    fun getAllPopularMovie(): Flowable<Resource<List<Movie>>>
    fun getFavoriteMovie(): Flowable<List<Movie>>
    fun setFavoriteMovie(movie: Movie, state: Boolean)
}