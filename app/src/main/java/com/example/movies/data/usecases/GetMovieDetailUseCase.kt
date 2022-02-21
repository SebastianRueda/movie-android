package com.example.movies.data.usecases

import com.example.movies.data.repositories.MoviesRepository
import com.example.movies.data.util.DataStatus
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class GetMovieDetailUseCase(
    private val moviesRepository: MoviesRepository
) {
    operator fun invoke(id: Int) = flow {
        emit(DataStatus.Loading())

        val detail = moviesRepository.getMovieDetail(id)
        emit(DataStatus.Success(detail))
    }.catch { e -> emit(DataStatus.Error(e.message ?: "Error")) }
}