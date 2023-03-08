package com.example.capstonemovieapp.core.di

import com.example.capstonemovieapp.core.data.MovieRepository
import com.example.capstonemovieapp.core.domain.repository.IMovieRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(movieRepository: MovieRepository): IMovieRepository

}