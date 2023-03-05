package com.example.capstonemovieapp.core.di

import android.content.Context
import com.example.capstonemovieapp.core.data.MovieRepository
import com.example.capstonemovieapp.core.data.source.local.LocalDataSource
import com.example.capstonemovieapp.core.data.source.local.room.MovieDatabase
import com.example.capstonemovieapp.core.data.source.remote.RemoteDataSource
import com.example.capstonemovieapp.core.data.source.remote.network.ApiConfig
import com.example.capstonemovieapp.core.domain.repository.IMovieRepository
import com.example.capstonemovieapp.core.domain.usecase.MovieInteractor
import com.example.capstonemovieapp.core.domain.usecase.MovieUseCase
import com.example.capstonemovieapp.core.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): IMovieRepository {
        val database = MovieDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.movieDao())
        val appExecutors = AppExecutors()

        return MovieRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideMovieUseCase(context: Context): MovieUseCase {
        val repository = provideRepository(context)
        return MovieInteractor(repository)
    }
}
