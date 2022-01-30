package com.example.movies.data.entities

data class MovieDetail(
    val id: Int,
    val title: String,
    val image: String,
    val overview: String,
    val genres: List<Genre>,
    val page: String,
)
