package com.example.capstonemovieapp.core.data.source.local

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.capstonemovieapp.core.data.source.local.entity.MovieEntity
import com.example.capstonemovieapp.core.data.source.local.room.MovieDao
import io.reactivex.Flowable

class LocalDataSource private constructor(private val movieDao: MovieDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(movieDao)
            }
    }

    fun getAllPopularMovie(): Flowable<List<MovieEntity>> = movieDao.getAllPopularMovie()

    fun getFavoriteMovie(): Flowable<List<MovieEntity>> = movieDao.getFavoriteMovie()

    fun insertMovie(tourismList: List<MovieEntity>) = movieDao.insertMovie(tourismList)

    fun setFavoriteTourism(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        movieDao.updateFavoriteMovie(movie)
    }
}