package com.example.movies.data.repositories

import com.example.movies.data.entities.Movie
import com.example.movies.data.entities.MovieDetail

interface MoviesRepository {
    suspend fun getPopularMovies(): List<Movie>
    suspend fun getMovieDetail(id: Int): MovieDetail
}