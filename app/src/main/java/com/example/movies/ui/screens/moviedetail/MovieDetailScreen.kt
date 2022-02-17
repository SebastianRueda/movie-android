package com.example.movies.ui.screens.moviedetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movies.ui.components.Loading

@Composable
fun MovieDetailScreen(id: Int, onClickBack: () -> Unit, viewModel: MovieDetailViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

        LaunchedEffect(true) {
            viewModel.getMovieDetail(id)
        }

        when (val state = viewModel.uiState) {
            MovieDetailViewModel.UIModel.Loading -> Loading()
            is MovieDetailViewModel.UIModel.Content -> MovieDetailContent(movieDetail = state.movieDetail, onClickBack)
            is MovieDetailViewModel.UIModel.Error -> Text(text = state.error)
        }
    }
}