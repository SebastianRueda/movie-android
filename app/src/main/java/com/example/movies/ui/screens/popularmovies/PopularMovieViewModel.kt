package com.example.movies.ui.screens.popularmovies

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.entities.Movie
import com.example.movies.data.usecases.GetPopularMoviesUseCase
import com.example.movies.data.util.DataStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PopularMovieViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {
    sealed class UIModel {
        object Loading: UIModel()
        class PopularMovie(val movies: List<Movie>): UIModel()
        object Error: UIModel()
    }

    var uiModelState by mutableStateOf<UIModel>(UIModel.Loading)
        private set

    init {
        getPopularMovies()
    }

    private fun getPopularMovies() {
        getPopularMoviesUseCase().onEach { dataStatus ->
            uiModelState = when (dataStatus) {
                is DataStatus.Error -> UIModel.Error
                is DataStatus.Loading -> UIModel.Loading
                is DataStatus.Success -> UIModel.PopularMovie(dataStatus.data!!)
            }
        }.launchIn(viewModelScope)
    }
}