package com.example.capstonemovieapp.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.capstonemovieapp.R
import com.example.core.domain.model.Movie
import com.example.capstonemovieapp.databinding.ActivityDetailMovieBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailMovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailMovieBinding
    private val detailMovieViewModel: DetailMovieViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Detail Movie"

        val data = intent?.getParcelableExtra<Movie>(EXTRA_DATA)
        binding.tvOverview.text = data?.overview
        binding.title.text = data?.title
        Glide.with(applicationContext).load("https://image.tmdb.org/t/p/w500"+data?.posterPath).placeholder(R.drawable.cinema)
            .into(binding.poster)

        var statusFavorite = data?.isFavorite
        if (statusFavorite != null) {
            setStatusFavorite(statusFavorite)
        }

        binding.fabFav.setOnClickListener {
            statusFavorite = !statusFavorite!!
            if (data != null) {
                statusFavorite?.let { it1 -> detailMovieViewModel.setFavoriteMovie(data, it1) }
            }
            statusFavorite?.let { it1 -> setStatusFavorite(it1) }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fabFav.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_white
                )
            )
        } else {
            binding.fabFav.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_not_favorite_white
                )
            )
        }
    }

    companion object {
        const val EXTRA_DATA = "EXTRA_DATA"
    }
}