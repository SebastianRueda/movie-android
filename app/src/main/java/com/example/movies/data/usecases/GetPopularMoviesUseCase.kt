package com.example.movies.data.usecases

import com.example.movies.data.repositories.MoviesRepository

class GetPopularMoviesUseCase(
    private val moviesRepository: MoviesRepository
) {
    operator fun invoke() = moviesRepository.getPopularMovies()
}