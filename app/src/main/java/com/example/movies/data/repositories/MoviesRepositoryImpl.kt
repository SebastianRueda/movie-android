package com.example.movies.data.repositories

import com.example.movies.data.remotedatasource.RemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class MoviesRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val dispatcher: CoroutineDispatcher
) : MoviesRepository {

    override suspend fun getPopularMovies() = withContext(dispatcher) { remoteDataSource.getPopularMovies() }

    override suspend fun getMovieDetail(id: Int) = withContext(dispatcher) {
        remoteDataSource.getMovieDetail(id)
    }
}