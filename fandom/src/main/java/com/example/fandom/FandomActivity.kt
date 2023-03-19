package com.example.fandom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.capstonemovieapp.di.FandomModuleDependencies
import com.example.core.data.Resource
import javax.inject.Inject
import com.example.fandom.databinding.ActivityFandomBinding
import dagger.hilt.android.EntryPointAccessors


class FandomActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelFactory

    private val fandomViewModel: FandomViewModel by viewModels {
        factory
    }

    private lateinit var binding: ActivityFandomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFandomComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    FandomModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityFandomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Fandom Menu"

        getMovieData()
    }

    private fun getMovieData() {
        fandomViewModel.movie.observe(this) { movie ->
            if (movie != null) {
                when (movie) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvFandom.text =
                            "This is fandom of ${movie.data?.get(0)?.title},the page is not ready yet"
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvError.visibility = View.VISIBLE
                        binding.tvError.text = movie.message
                    }
                }
            }
        }
    }
}