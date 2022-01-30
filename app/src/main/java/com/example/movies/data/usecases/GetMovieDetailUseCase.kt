package com.example.movies.data.usecases

import com.example.movies.data.repositories.MoviesRepository
import com.example.movies.data.util.DataStatus
import kotlinx.coroutines.flow.flow

class GetMovieDetailUseCase(
    private val moviesRepository: MoviesRepository
) {
    operator fun invoke(id: Int) = flow {
        emit(DataStatus.Loading())

        try {
            val data = moviesRepository.getMovieDetail(id)
            emit(DataStatus.Success(data))
        } catch (e: Exception) {
            emit(DataStatus.Error(""))
        }

    }
}