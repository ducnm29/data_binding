package com.ducnm.bruhmovie.di

import com.ducnm.bruhmovie.data.network.NetworkManager
import com.ducnm.bruhmovie.data.network.movie.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideMovieApi(): MovieApi = NetworkManager.createMovieApi()
}