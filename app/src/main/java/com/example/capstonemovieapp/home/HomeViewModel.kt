package com.example.capstonemovieapp.home

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.example.capstonemovieapp.core.domain.usecase.MovieUseCase

class HomeViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val movie = LiveDataReactiveStreams.fromPublisher(movieUseCase.getAllPopularMovie())
}