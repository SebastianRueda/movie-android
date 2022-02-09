package com.example.movies.ui.screens.popularmovies

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movies.ui.components.Loading

@Composable
@ExperimentalFoundationApi
fun PopularMovies(onClickMovie: (Int) -> Unit, viewModel: PopularMovieViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (val state = viewModel.uiModelState) {
            PopularMovieViewModel.UIModel.Error -> Text(text = "Error")
            PopularMovieViewModel.UIModel.Loading -> Loading()
            is PopularMovieViewModel.UIModel.PopularMovie -> PopularMoviesContent(movies = state.movies, onClickMovie = onClickMovie)
        }
    }
}

@Preview
@Composable
private fun Preview() {
    //HomeScreen()
}