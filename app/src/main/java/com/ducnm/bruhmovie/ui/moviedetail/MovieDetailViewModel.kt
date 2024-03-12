package com.ducnm.bruhmovie.ui.moviedetail

import android.util.Log
import androidx.lifecycle.ViewModel

class MovieDetailViewModel : ViewModel() {
    private lateinit var movieId: String
    fun setMovieId(movieId: String) {
        this.movieId = movieId
        Log.d("Test", "movieId: $movieId")
    }
}