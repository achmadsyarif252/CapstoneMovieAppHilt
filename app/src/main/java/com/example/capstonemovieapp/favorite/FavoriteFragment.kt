package com.example.capstonemovieapp.favorite

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.capstonemovieapp.R
import com.example.capstonemovieapp.core.data.Resource
import com.example.capstonemovieapp.core.ui.MovieAdapter
import com.example.capstonemovieapp.core.ui.ViewModelFactory
import com.example.capstonemovieapp.databinding.FragmentFavoriteBinding
import com.example.capstonemovieapp.detail.DetailMovieActivity
import com.example.capstonemovieapp.home.HomeViewModel

class FavoriteFragment : Fragment() {
    private lateinit var favoriteViewModel: FavoriteViewModel
    private var _binding: FragmentFavoriteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val favMovieAdapter = MovieAdapter()
            favMovieAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailMovieActivity::class.java)
                intent.putExtra(DetailMovieActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }
            val factory = ViewModelFactory.getInstance(requireActivity())
            val favoriteViewModel =
                ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            favoriteViewModel.favoriteMovie.observe(viewLifecycleOwner) { dataMovie ->
                favMovieAdapter.setData(dataMovie)
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
}