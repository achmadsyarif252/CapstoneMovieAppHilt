package com.example.capstonemovieapp.core.domain.usecase

import androidx.lifecycle.LiveData
import com.example.capstonemovieapp.core.data.Resource
import com.example.capstonemovieapp.core.domain.model.Movie
import com.example.capstonemovieapp.core.domain.repository.IMovieRepository

class MovieInteractor(private val movieRepository: IMovieRepository) : MovieUseCase {
    override fun getAllPopularMovie() = movieRepository.getAllPopularMovie()

    override fun getFavoriteMovie() = movieRepository.getFavoriteMovie()

    override fun setFavoriteMovie(movie: Movie, state: Boolean) =
        movieRepository.setFavoriteMovie(movie, state)
}