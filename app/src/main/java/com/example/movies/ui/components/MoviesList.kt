package com.example.movies.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movies.data.entities.Movie
import com.example.movies.ui.theme.Dimens

@Composable
@ExperimentalFoundationApi
fun MoviesList(onClickMovie: (Int) -> Unit, movies: List<Movie> = emptyList(), modifier: Modifier = Modifier) {
    val state = rememberLazyListState()

    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 160.dp),
        modifier = modifier.padding(Dimens.spacing_small),
        state = state
    ) {
        items(movies) { movie ->
            MovieItem(movie = movie, onClickMovie)
        }
    }
}