package com.example.movies.data.repositories

import com.example.movies.data.entities.Movie
import com.example.movies.data.entities.MovieDetail
import com.example.movies.data.util.DataStatus
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getPopularMovies(): Flow<DataStatus<List<Movie>>>
    fun getMovieDetail(id: Int): Flow<DataStatus<MovieDetail>>
}