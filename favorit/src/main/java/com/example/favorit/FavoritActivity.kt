package com.example.favorit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.capstonemovieapp.detail.DetailMovieActivity
import com.example.capstonemovieapp.di.FavoritModuleDependencies
import com.example.core.ui.MovieAdapter
import com.example.favorit.databinding.ActivityFavoritBinding
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject


class FavoritActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelFactory

    private val favoriteViewModel: FavoriteViewModel by viewModels {
        factory
    }

    private lateinit var binding: ActivityFavoritBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFavoriteComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    FavoritModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)

        super.onCreate(savedInstanceState)
        binding = ActivityFavoritBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Your Favorite Movie"

        val favMovieAdapter = MovieAdapter()
        favMovieAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailMovieActivity::class.java)
            intent.putExtra(DetailMovieActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        favoriteViewModel.favoriteMovie.observe(this) { dataMovie ->
            favMovieAdapter.setData(dataMovie)
            Log.d("Fav Movie", dataMovie.joinToString("\n") + "OKOKO")
            binding.viewEmpty.root.visibility =
                if (dataMovie.isNotEmpty()) View.GONE else View.VISIBLE
        }

        with(binding.rvMovieFav) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = favMovieAdapter
        }

    }
}
