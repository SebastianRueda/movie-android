package com.example.movies.ui.screens.moviedetail

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun MovieDetail(id: String) {
    Box {
        Text(text = "$id")
    }
}