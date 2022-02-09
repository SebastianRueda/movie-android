package com.example.movies.data.repositories

import com.example.movies.data.remotedatasource.RemoteDataSource
import com.example.movies.data.util.DataStatus
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MoviesRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val dispatcher: CoroutineDispatcher
) : MoviesRepository {

    override fun getPopularMovies() = flow {
        emit(DataStatus.Loading())

        try {
            val response = remoteDataSource.getPopularMovies()
            emit(DataStatus.Success(response))
        } catch (e: Exception) {
            emit(DataStatus.Error(e.message ?: ""))
        }
    }.flowOn(dispatcher)

    override fun getMovieDetail(id: Int) = flow {
        emit(DataStatus.Loading())

        try {
            val response = remoteDataSource.getMovieDetail(id)
            emit(DataStatus.Success(response))
        } catch (e: Exception) {
            emit(DataStatus.Error(e.message ?: ""))
        }
    }.flowOn(dispatcher)
}