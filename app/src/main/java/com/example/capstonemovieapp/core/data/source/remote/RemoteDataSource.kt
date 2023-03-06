package com.example.capstonemovieapp.core.data.source.remote

import android.util.Log
import com.example.capstonemovieapp.BuildConfig
import com.example.capstonemovieapp.core.data.source.remote.network.ApiResponse
import com.example.capstonemovieapp.core.data.source.remote.network.ApiService
import com.example.capstonemovieapp.core.data.source.remote.response.MovieResponse
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

class RemoteDataSource private constructor(private val apiService: ApiService) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    fun getAllMovie(): Flowable<ApiResponse<List<MovieResponse>>> {
        val resultData = PublishSubject.create<ApiResponse<List<MovieResponse>>>()
        val client = apiService.getList(BuildConfig.API_KEY)

        client.subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe({ response ->
                val dataArray = response.results
                if (dataArray != null) {
                    resultData.onNext((if (dataArray.isNotEmpty()) ApiResponse.Success(dataArray) else ApiResponse.Empty))
                }
            }, { error ->
                resultData.onNext(ApiResponse.Error(error.message.toString()))
                Log.e("RemoteDataSource", error.toString())
            })
        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }
}

