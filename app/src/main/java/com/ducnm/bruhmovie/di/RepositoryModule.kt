package com.ducnm.bruhmovie.di

import com.ducnm.bruhmovie.data.network.movie.MovieApi
import com.ducnm.bruhmovie.repository.MovieRepository
import com.ducnm.bruhmovie.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(movieApi: MovieApi): MovieRepository{
        return MovieRepositoryImpl(movieApi = movieApi)
    }
}