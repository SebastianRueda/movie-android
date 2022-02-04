package com.example.movies.ui.screens.home

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
import com.example.movies.data.entities.Movie
import com.example.movies.ui.components.Loading

@Composable
@ExperimentalFoundationApi
fun HomeScreen(onClickMovie: (Movie) -> Unit, viewModel: HomeViewModel = hiltViewModel()) {
    LaunchedEffect(true) {
        viewModel.getPopularMovies()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (val state = viewModel.uiModelState) {
            HomeViewModel.UIModel.Error -> Text(text = "Error")
            HomeViewModel.UIModel.Loading -> Loading()
            is HomeViewModel.UIModel.PopularMovie -> HomeContent(movies = state.movies, onClickMovie = onClickMovie)
        }
    }
}

@Preview
@Composable
private fun Preview() {
    //HomeScreen()
}