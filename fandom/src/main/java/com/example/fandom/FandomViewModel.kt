package com.example.fandom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.MovieUseCase

class FandomViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val movie = movieUseCase.getAllPopularMovie().asLiveData()
}