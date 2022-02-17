package com.example.movies.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter

@Composable
fun ImageCoil(url: String, contentDescription: String? = null, modifier: Modifier = Modifier) {
    Image(
        painter = rememberImagePainter(
            data = url,
            builder = {
                crossfade(true)
            }
        ),
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}