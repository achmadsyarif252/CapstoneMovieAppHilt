package com.example.capstonemovieapp.core.data.source.local

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.capstonemovieapp.core.data.source.local.entity.MovieEntity
import com.example.capstonemovieapp.core.data.source.local.room.MovieDao
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class LocalDataSource @Inject constructor(private val movieDao: MovieDao) {

    fun getAllPopularMovie(): Flowable<List<MovieEntity>> = movieDao.getAllPopularMovie()

    fun getFavoriteMovie(): Flowable<List<MovieEntity>> = movieDao.getFavoriteMovie()

    fun insertMovie(tourismList: List<MovieEntity>) = movieDao.insertMovie(tourismList)

    fun setFavoriteTourism(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        movieDao.updateFavoriteMovie(movie)
    }
}