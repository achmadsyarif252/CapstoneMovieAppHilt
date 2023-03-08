package com.example.capstonemovieapp.core.domain.usecase

import com.example.capstonemovieapp.core.domain.model.Movie
import com.example.capstonemovieapp.core.domain.repository.IMovieRepository
import javax.inject.Inject

class MovieInteractor @Inject constructor(private val movieRepository: IMovieRepository) : MovieUseCase {
    override fun getAllPopularMovie() = movieRepository.getAllPopularMovie()

    override fun getFavoriteMovie() = movieRepository.getFavoriteMovie()

    override fun setFavoriteMovie(movie: Movie, state: Boolean) =
        movieRepository.setFavoriteMovie(movie, state)
}