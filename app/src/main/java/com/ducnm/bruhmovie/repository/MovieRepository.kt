package com.ducnm.bruhmovie.repository

import com.ducnm.bruhmovie.data.network.movie.DataListResponse
import com.ducnm.bruhmovie.model.Movie
import com.ducnm.bruhmovie.model.Result
import kotlinx.coroutines.flow.Flow


interface MovieRepository {
    fun getPopularMovies(language: String, apiKey: String): Flow<Result<DataListResponse<Movie>>>
}