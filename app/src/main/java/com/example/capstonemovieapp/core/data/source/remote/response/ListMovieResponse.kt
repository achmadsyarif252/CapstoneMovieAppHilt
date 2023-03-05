package com.example.capstonemovieapp.core.data.source.remote.response
import com.google.gson.annotations.SerializedName


class ListMovieResponse(
	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("results")
	val results: List<MovieResponse>? = null
)
