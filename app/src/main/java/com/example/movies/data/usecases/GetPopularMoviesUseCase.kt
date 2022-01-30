package com.example.movies.data.usecases

import com.example.movies.data.repositories.MoviesRepository
import com.example.movies.data.util.DataStatus
import kotlinx.coroutines.flow.flow

class GetPopularMoviesUseCase(
    private val moviesRepository: MoviesRepository
) {
    operator fun invoke() = flow {
        emit(DataStatus.Loading())

        try {
            val data = moviesRepository.getPopularMovies()
            emit(DataStatus.Success(data))
        } catch (e: Exception) {
            emit(DataStatus.Error(e.message ?: ""))
        }
    }
}