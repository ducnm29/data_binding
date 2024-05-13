package com.ducnm.bruhmovie.ui.movie

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.ducnm.bruhmovie.BaseFragment
import com.ducnm.bruhmovie.R
import com.ducnm.bruhmovie.adapter.MovieListAdapter
import com.ducnm.bruhmovie.databinding.MovieFragmentBinding
import com.ducnm.bruhmovie.ultil.CommonUtil.flowWithViewLifecycle
import com.ducnm.bruhmovie.ultil.Define
import com.google.android.material.transition.MaterialElevationScale
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MovieFragment : BaseFragment<MovieFragmentBinding, MovieViewModel>() {
    override val viewModel by viewModels<MovieViewModel>()
    override val layoutRes = R.layout.movie_fragment
    private lateinit var movieListAdapter: MovieListAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPopularMovies()
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun setUpPopularMovies() {
        movieListAdapter = MovieListAdapter(
            onClick = { _, movieId ->
                navigateMovieDetail(movieId = movieId)
            }
        )
        binding.recycleViewMovieList.adapter = movieListAdapter
        flowWithViewLifecycle(viewModel.uiState) {
            movieListAdapter.updateMovieList(it.popularMovies)
            Log.d("TEST", it.popularMovies.toString())
            movieListAdapter.notifyDataSetChanged()
        }
    }

    private fun navigateMovieDetail(movieId: String){
        exitTransition = MaterialElevationScale(true)
        reenterTransition = MaterialElevationScale(true)
        val direction = MovieFragmentDirections.movieToMovieDetail(movieId = movieId)
        navController.navigate(directions = direction)
    }
}