package com.example.movies.data.remotedatasource.themoviedb.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesResponse(
    @SerialName("page")
    val page: Int? = null,
    @SerialName("results")
    val results: List<MovieResponse> = emptyList(),
    @SerialName("total_pages")
    val totalPages: String? = null,
    @SerialName("total_results")
    val totalResults: String? = null
)