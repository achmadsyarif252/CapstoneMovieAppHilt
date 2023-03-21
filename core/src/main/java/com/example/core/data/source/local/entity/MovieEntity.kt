package com.example.core.data.source.local.entity

import android.os.Parcelable
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

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "posterPath")
    var posterPath: String? = null,

    @ColumnInfo(name = "backdropPath")
    var backdropPath: String? = null,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: String? = null,

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
) : Parcelable
