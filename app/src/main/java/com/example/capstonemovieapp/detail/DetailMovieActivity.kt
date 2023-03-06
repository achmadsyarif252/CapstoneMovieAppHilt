package com.example.capstonemovieapp.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.capstonemovieapp.R
import com.example.capstonemovieapp.core.domain.model.Movie
import com.example.capstonemovieapp.core.ui.ViewModelFactory
import com.example.capstonemovieapp.databinding.ActivityDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailMovieBinding
    private lateinit var detailMovieViewModel: DetailMovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        detailMovieViewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        val data = intent?.getParcelableExtra<Movie>(EXTRA_DATA)
        binding.tvDetailMovie.text = data?.overview

        var statusFavorite = data?.isFavorite
        if (statusFavorite != null) {
            setStatusFavorite(statusFavorite)
            Toast.makeText(this@DetailMovieActivity, "$statusFavorite", Toast.LENGTH_LONG).show()
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