package com.example.movies.data.usecases

import com.example.movies.data.repositories.MoviesRepository

class GetMovieDetailUseCase(
    private val moviesRepository: MoviesRepository
) {
    operator fun invoke(id: Int) = moviesRepository.getMovieDetail(id)
}