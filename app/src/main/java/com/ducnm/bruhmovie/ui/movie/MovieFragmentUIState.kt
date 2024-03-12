package com.ducnm.bruhmovie.ui.movie

import com.ducnm.bruhmovie.model.Movie

data class MovieFragmentUIState(
    val popularMovies: List<Movie> = listOf()
){
    companion object{
        val EMPTY = MovieFragmentUIState()
    }
}