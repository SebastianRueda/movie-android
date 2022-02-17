package com.example.movies.data.remotedatasource.themoviedb.mapper

import com.example.movies.data.entities.Genre
import com.example.movies.data.entities.Movie
import com.example.movies.data.entities.MovieDetail
import com.example.movies.data.remotedatasource.themoviedb.response.GenreResponse
import com.example.movies.data.remotedatasource.themoviedb.response.MovieDetailResponse
import com.example.movies.data.remotedatasource.themoviedb.response.MovieResponse

private const val imageUrlBase = "https://image.tmdb.org/t/p/w500/"
private const val imageOriginalUrlBase = "https://image.tmdb.org/t/p/original/"

fun MovieResponse.mapMovie() =
    Movie(
        id = id ?: -1,
        title = title ?: "",
        image = "$imageUrlBase$posterPath"
    )

fun GenreResponse.mapGenre() =
    Genre(
        id ?: -1,
        name ?: ""
    )

fun MovieDetailResponse.mapMovieDetail() =
    MovieDetail(
        id = id ?: -1,
        title = title ?: "",
        image = "$imageOriginalUrlBase$posterPath",
        genres = genres?.map { it.mapGenre() } ?: emptyList(),
        overview = overview ?: "",
        page = homepage ?: ""
    )