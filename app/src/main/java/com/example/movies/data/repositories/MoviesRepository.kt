package com.example.movies.data.repositories

import com.example.movies.data.entities.Movie
import com.example.movies.data.entities.MovieDetail
import com.example.movies.data.util.DataStatus
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun getPopularMovies(): List<Movie>
    suspend fun getMovieDetail(id: Int): MovieDetail
}