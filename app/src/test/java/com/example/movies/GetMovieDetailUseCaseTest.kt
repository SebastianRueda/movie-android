package com.example.movies

import com.example.movies.data.entities.MovieDetail
import com.example.movies.data.repositories.MoviesRepository
import com.example.movies.data.usecases.GetMovieDetailUseCase
import com.example.movies.data.util.DataStatus
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class GetMovieDetailUseCaseTest {
    private val moviesRepository = Mockito.mock(MoviesRepository::class.java)
    private val getMovieDetailUseCase = GetMovieDetailUseCase(moviesRepository)

    @Test
    fun `when call getMovieDetail(), should get movie detail`() = runTest {
        // given a movie
        val movie = MovieDetail(1, "test", "image", "", emptyList(), "")

        whenever(moviesRepository.getMovieDetail(movie.id)).thenReturn(movie)

        // when invoke the use case
        val (loading, success) = getMovieDetailUseCase(movie.id).toList()

        // then get the movie expected
        Assert.assertTrue(loading is DataStatus.Loading)
        Assert.assertTrue(success is DataStatus.Success)
        Assert.assertEquals(success.data, movie)
    }

    @Test
    fun `when call getMovieDetail() fail`() = runTest {
        val movieId = 1

        whenever(moviesRepository.getMovieDetail(movieId)).then { throw Exception("Error") }

        val (loading, error) = getMovieDetailUseCase(movieId).toList()

        Assert.assertTrue(loading is DataStatus.Loading)
        Assert.assertTrue(error is DataStatus.Error)
    }
}