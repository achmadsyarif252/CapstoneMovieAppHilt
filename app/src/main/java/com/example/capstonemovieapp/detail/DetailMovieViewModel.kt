package com.example.capstonemovieapp.detail

import androidx.lifecycle.ViewModel
import com.example.capstonemovieapp.core.domain.model.Movie
import com.example.capstonemovieapp.core.domain.usecase.MovieUseCase

class DetailMovieViewModel(private val movieUseCase: MovieUseCase):ViewModel() {
    fun setFavoriteMovie(movie: Movie, newStatus:Boolean) = movieUseCase.setFavoriteMovie(movie, newStatus)

}