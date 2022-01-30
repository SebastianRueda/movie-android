package com.example.movies.data.remotedatasource

import com.example.movies.data.entities.Movie
import com.example.movies.data.entities.MovieDetail

interface RemoteDataSource {
    suspend fun getPopularMovies(): List<Movie>
    suspend fun getMovieDetail(id: Int): MovieDetail
}