package com.example.movies

import com.example.movies.data.entities.Movie
import com.example.movies.data.repositories.MoviesRepository
import com.example.movies.data.usecases.GetPopularMoviesUseCase
import com.example.movies.data.util.DataStatus
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.kotlin.*

@ExperimentalCoroutinesApi
class GetPopularMoviesUseCaseTest {
    @Mock
    private val moviesRepository = Mockito.mock(MoviesRepository::class.java)
    private val getPopularMoviesUseCase = GetPopularMoviesUseCase(moviesRepository)

    @Test
    fun `when call success getPopularMovies(), should get popular movies`() = runTest {
        val movies = mutableListOf<Movie>().apply {
            add(Movie(1, "title", "url"))
            add(Movie(2, "title - revenge", "url"))
        }

        whenever(moviesRepository.getPopularMovies()).doReturn(movies)

        // when invoke
        val (loading, success) = getPopularMoviesUseCase().toList()

        // then get the movies expected
        Assert.assertTrue(loading is DataStatus.Loading)
        Assert.assertTrue(success is DataStatus.Success)
        Assert.assertEquals(success.data!!.size, movies.size)
    }

    @Test
    fun `when call getPopularMovies() fail`() = runTest {
        whenever(moviesRepository.getPopularMovies()).then { throw Exception() }

        // when invoke
        val (loading, error) = getPopularMoviesUseCase().toList()

        // then
        Assert.assertTrue(loading is DataStatus.Loading)
        Assert.assertTrue(error is DataStatus.Error)
    }
}