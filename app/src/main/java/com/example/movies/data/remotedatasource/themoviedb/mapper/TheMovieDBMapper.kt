package com.example.movies.data.remotedatasource.themoviedb.mapper

import com.example.movies.data.entities.Movie
import com.example.movies.data.remotedatasource.themoviedb.response.MovieResponse

private const val imageUrlBase = "https://image.tmdb.org/t/p/w500/"
private const val imageOriginalUrlBase = "https://image.tmdb.org/t/p/original/"

fun MovieResponse.mapMovie() =
    Movie(
        id = id ?: -1,
        title = title ?: "",
        image = "$imageUrlBase$posterPath"
    )