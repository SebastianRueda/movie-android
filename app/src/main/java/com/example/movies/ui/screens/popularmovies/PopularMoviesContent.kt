package com.example.movies.ui.screens.popularmovies

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.movies.R
import com.example.movies.data.entities.Movie
import com.example.movies.ui.components.MoviesList

@ExperimentalFoundationApi
@Composable
fun PopularMoviesContent(movies: List<Movie> = emptyList(), onClickMovie: (Int) -> Unit) {
    Column() {
        TopAppBar(
            title = {
                Text(text = stringResource(R.string.home_screen_title))
            },
        )
        MoviesList(movies = movies, onClickMovie = onClickMovie)
    }
}