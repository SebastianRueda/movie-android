package com.example.movies.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movies.ui.screens.popularmovies.PopularMovies
import com.example.movies.ui.screens.moviedetail.MovieDetail

@Composable
@ExperimentalFoundationApi
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.POPULAR_MOVIE.value) {
        composable(NavRoute.POPULAR_MOVIE.value) {
            PopularMovies({ movieId ->
                navController.navigate("${NavRoute.MOVIE_DETAIL.value}/$movieId")
            })
        }

        composable(NavRoute.MOVIE_DETAIL.value + "/{movie_id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("movie_id") ?: "-1"
            MovieDetail(id = id)
        }
    }
}

enum class NavRoute(val value: String) {
    POPULAR_MOVIE("popular_movie"),
    MOVIE_DETAIL("movie_detail")
}