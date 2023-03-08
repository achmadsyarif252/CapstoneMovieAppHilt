package com.example.capstonemovieapp.core.data

import com.example.capstonemovieapp.core.utils.DataMapper
import com.example.capstonemovieapp.core.data.source.local.LocalDataSource
import com.example.capstonemovieapp.core.data.source.remote.RemoteDataSource
import com.example.capstonemovieapp.core.data.source.remote.network.ApiResponse
import com.example.capstonemovieapp.core.data.source.remote.response.MovieResponse
import com.example.capstonemovieapp.core.domain.model.Movie
import com.example.capstonemovieapp.core.domain.repository.IMovieRepository
import com.example.capstonemovieapp.core.utils.AppExecutors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMovieRepository {

    override fun getAllPopularMovie(): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getAllPopularMovie()
                    .map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovie()

            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovie(movieList = movieList)
            }
        }.asFlow()



    override fun getFavoriteMovie(): Flow<List<Movie>> {
        return localDataSource.getFavoriteMovie().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteMovie(movie: Movie, state: Boolean) {
        val movieEntity = DataMapper.mapDomainToEntity(movie)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(movieEntity, state) }
    }
}
