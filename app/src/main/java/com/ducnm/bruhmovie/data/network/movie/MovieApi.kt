package com.ducnm.bruhmovie.data.network.movie

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String,
        @Query("api_key") apiKey: String
    ): DataListResponse<MovieResponse>
}