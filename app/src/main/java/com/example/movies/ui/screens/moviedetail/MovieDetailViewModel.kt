package com.example.movies.ui.screens.moviedetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.entities.MovieDetail
import com.example.movies.data.usecases.GetMovieDetailUseCase
import com.example.movies.data.util.DataStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase
) : ViewModel() {
    sealed class UIModel {
        object Loading : UIModel()
        class Content(val movieDetail: MovieDetail) : UIModel()
        class Error(val error: String) : UIModel()
    }

    var uiState by mutableStateOf<UIModel>(UIModel.Loading)
    private set

    fun getMovieDetail(id: Int) {
        getMovieDetailUseCase(id).onEach { state ->
            uiState = when (state) {
                is DataStatus.Error -> UIModel.Error(state.message ?: "")
                is DataStatus.Loading -> UIModel.Loading
                is DataStatus.Success -> UIModel.Content(state.data!!)
            }
        }.launchIn(viewModelScope)
    }
}