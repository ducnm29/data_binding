package com.ducnm.bruhmovie.ui.moviedetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ducnm.bruhmovie.BaseFragment
import com.ducnm.bruhmovie.R
import com.ducnm.bruhmovie.databinding.MovieDetailFragmentBinding

class MovieDetailFragment: BaseFragment<MovieDetailFragmentBinding, MovieDetailViewModel>() {
    private val safeArgs: MovieDetailFragmentArgs by navArgs()
    override val viewModel by viewModels<MovieDetailViewModel>()
    override val layoutRes = R.layout.movie_detail_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setMovieId(safeArgs.movieId)
    }
}