package com.example.capstonemovieapp.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "movie")
data class MovieEntity(
    @ColumnInfo(name = "overview")
    var overview: String? = null,

    @ColumnInfo(name = "originalLanguage")
    var originalLanguage: String? = null,

    @ColumnInfo(name = "originalTitle")
    var originalTitle: String? = null,

    @ColumnInfo(name = "video")
    var video: Boolean? = null,

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "genreIds")
    @field:TypeConverters(IntTypeConverter::class)
    var genreIds: List<Int?>? = null,

    @ColumnInfo(name = "posterPath")
    var posterPath: String? = null,

    @ColumnInfo(name = "backdropPath")
    var backdropPath: String? = null,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: String? = null,

    @ColumnInfo(name = "popularity")
    var popularity: Double? = null,

    @ColumnInfo(name = "voteAverage")
    var voteAverage: Double? = null,

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @ColumnInfo(name = "adult")
    var adult: Boolean? = null,

    @ColumnInfo(name = "voteCount")
    var voteCount: Int? = null,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
) : Parcelable
