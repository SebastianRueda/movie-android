package com.example.movies.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movies.ui.components.Loading
import com.example.movies.ui.components.MoviesList

@Composable
@ExperimentalFoundationApi
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    LaunchedEffect(true) {
        viewModel.getPopularMovies()
    }

    Box(contentAlignment = Alignment.Center) {
        when (val state = viewModel.uiModelState) {
            HomeViewModel.UIModel.Error -> Text(text = "Error")
            HomeViewModel.UIModel.Loading -> Loading()
            is HomeViewModel.UIModel.PopularMovie -> MoviesList(state.movies)
        }
    }
}

@Preview
@Composable
private fun Preview() {
    //HomeScreen()
}