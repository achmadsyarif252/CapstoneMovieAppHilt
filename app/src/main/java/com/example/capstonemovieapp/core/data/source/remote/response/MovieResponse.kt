package com.example.capstonemovieapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
	@field:SerializedName("overview")
	val overview: String? = null,

	@field:SerializedName("originalLanguage")
	val originalLanguage: String? = null,

	@field:SerializedName("originalTitle")
	val originalTitle: String? = null,

	@field:SerializedName("video")
	val video: Boolean? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("genreIds")
	val genreIds: List<Int?>? = null,

	@field:SerializedName("posterPath")
	val posterPath: String? = null,

	@field:SerializedName("backdropPath")
	val backdropPath: String? = null,

	@field:SerializedName("releaseDate")
	val releaseDate: String? = null,

	@field:SerializedName("popularity")
	val popularity: Double? = null,

	@field:SerializedName("voteAverage")
	val voteAverage: Double? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("adult")
	val adult: Boolean? = null,

	@field:SerializedName("voteCount")
	val voteCount: Int? = null
)
