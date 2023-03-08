package com.example.capstonemovieapp.favorite

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.example.capstonemovieapp.core.domain.usecase.MovieUseCase

class FavoriteViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val favoriteMovie = LiveDataReactiveStreams.fromPublisher(movieUseCase.getFavoriteMovie())

}