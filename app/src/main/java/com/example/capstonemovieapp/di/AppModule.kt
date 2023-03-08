package com.example.capstonemovieapp.di

import com.example.capstonemovieapp.core.domain.usecase.MovieInteractor
import com.example.capstonemovieapp.core.domain.usecase.MovieUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideMovieUseCase(movieInteractor: MovieInteractor): MovieUseCase

}