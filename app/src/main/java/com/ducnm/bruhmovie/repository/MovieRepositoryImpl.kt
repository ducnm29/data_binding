package com.ducnm.bruhmovie.repository

import com.ducnm.bruhmovie.data.network.movie.DataListResponse
import com.ducnm.bruhmovie.data.network.movie.MovieApi
import com.ducnm.bruhmovie.data.network.movie.toModel
import com.ducnm.bruhmovie.model.Movie
import com.ducnm.bruhmovie.model.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl(
    private val movieApi: MovieApi
) : MovieRepository {
    override fun getPopularMovies(
        language: String,
        apiKey: String
    ): Flow<Result<DataListResponse<Movie>>> {
        return flow {
            emit(Result.Loading)
            val data = movieApi.getPopularMovies(language = language, apiKey = apiKey)
            val dataParse = data.toModel { data.dataList.map { it.toModel() } }
            emit(Result.Success(data = dataParse))
        }.catch { error ->
            emit(Result.Error(error.message.orEmpty()))
        }
    }
}