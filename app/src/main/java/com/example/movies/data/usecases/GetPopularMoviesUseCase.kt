package com.example.movies.data.usecases

import com.example.movies.data.repositories.MoviesRepository
import com.example.movies.data.util.DataStatus
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class GetPopularMoviesUseCase(
    private val moviesRepository: MoviesRepository
) {
    operator fun invoke() = flow {
        emit(DataStatus.Loading())

        val movies = moviesRepository.getPopularMovies()
        emit(DataStatus.Success(movies))
    }.catch { e -> emit(DataStatus.Error(e.message ?: "Error")) }
}