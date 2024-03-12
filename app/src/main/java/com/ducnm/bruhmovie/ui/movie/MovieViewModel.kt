package com.ducnm.bruhmovie.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ducnm.bruhmovie.BuildConfig
import com.ducnm.bruhmovie.model.Result
import com.ducnm.bruhmovie.repository.MovieRepository
import com.ducnm.bruhmovie.ultil.Define
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(MovieFragmentUIState.EMPTY)
    val uiState: StateFlow<MovieFragmentUIState> = _uiState.asStateFlow()

    init {
        getPopularMovies()
    }

    private fun getPopularMovies() {
        viewModelScope.launch {
            movieRepository.getPopularMovies(
                language = Define.LANGUAGE_DEFAULT,
                apiKey = BuildConfig.API_KEY
            ).collectLatest { result ->
                when (result){
                    is Result.Error -> {

                    }
                    is Result.Loading -> {

                    }
                    is Result.Success -> {
                        _uiState.update { it.copy(popularMovies = result.data.dataList) }
                    }
                }
            }
        }
    }

    var txtName: String = "Movie ViewModel"

    fun onBtnClick(newValue: String) {
        txtName = newValue
    }

}