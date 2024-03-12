package com.ducnm.bruhmovie.data.network

import com.ducnm.bruhmovie.data.network.movie.MovieApi
import com.ducnm.bruhmovie.ultil.Define
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {

    fun createMovieApi(): MovieApi = createRetrofit().create(MovieApi::class.java)

    private fun createRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(Define.BASE_URL)
            .client(createClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }.build()
    }
}