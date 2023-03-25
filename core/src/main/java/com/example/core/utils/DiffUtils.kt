package com.example.core.utils

import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import com.example.core.domain.model.Movie

class DiffUtils(private val oldList: List<Movie>, private val newList: List<Movie>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        val (
            overview,
            originalLanguage,
            originalTitle,
            video,
            title,
        ) = oldList[oldPosition]
        val (
            overview1,
            originalLanguage1,
            originalTitle1,
            video1,
            title1,
        ) = newList[newPosition]

        return overview == overview1 &&
                originalLanguage == originalLanguage1 &&
                originalTitle == originalTitle1 &&
                video == video1 &&
                title == title1
    }

    @Nullable
    override fun getChangePayload(oldPosition: Int, newPosition: Int): Any? {
        return super.getChangePayload(oldPosition, newPosition)
    }
}