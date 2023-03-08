package com.example.capstonemovieapp.core.data.source.local

import com.example.capstonemovieapp.core.data.source.local.entity.MovieEntity
import com.example.capstonemovieapp.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class LocalDataSource @Inject constructor(private val movieDao: MovieDao) {

    fun getAllPopularMovie(): Flow<List<MovieEntity>> = movieDao.getAllPopularMovie()

    fun getFavoriteMovie(): Flow<List<MovieEntity>> = movieDao.getFavoriteMovie()

    suspend fun insertMovie(movieList: List<MovieEntity>) = movieDao.insertMovie(movieList)

    fun setFavoriteTourism(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        movieDao.updateFavoriteMovie(movie)
    }
}