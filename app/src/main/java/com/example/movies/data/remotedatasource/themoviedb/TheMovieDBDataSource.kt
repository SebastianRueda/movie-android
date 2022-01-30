package com.example.movies.data.remotedatasource.themoviedb

import com.example.movies.data.entities.Movie
import com.example.movies.data.entities.MovieDetail
import com.example.movies.data.remotedatasource.RemoteDataSource
import com.example.movies.data.remotedatasource.themoviedb.mapper.mapMovie
import com.example.movies.data.remotedatasource.themoviedb.response.MoviesResponse
import io.ktor.client.*
import io.ktor.client.request.*

class TheMovieDBDataSource(
    private val httpClient: HttpClient,
    private val apiKey: String
) : RemoteDataSource {

    private companion object {
        private const val URL_BASE = "https://api.themoviedb.org/3"
    }

    private suspend inline fun <reified T> HttpClient.get(endpoint: String, params: Map<String, String> = emptyMap()): T {
        var url = "$URL_BASE/$endpoint?api_key=$apiKey&"

        params.forEach { (key, value) ->
            url += "$key=$value&"
        }

        return get {
            url(url)
        }
    }

    override suspend fun getPopularMovies(): List<Movie> =
        httpClient.get<MoviesResponse>("movie/popular").results.map { it.mapMovie() }

    override suspend fun getMovieDetail(id: Int): MovieDetail = httpClient.get("movie/$id")
}