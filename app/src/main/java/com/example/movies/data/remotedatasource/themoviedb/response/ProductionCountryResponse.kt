package com.example.movies.data.remotedatasource.themoviedb.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductionCountryResponse(
    @SerialName("iso_3166_1")
    val iso31661: String?,
    @SerialName("name")
    val name: String?
)