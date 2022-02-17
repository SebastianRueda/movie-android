package com.example.movies.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.movies.data.entities.Movie
import com.example.movies.ui.theme.Dimens

@Composable
fun MovieItem(movie: Movie, onClickMovie: (Int) -> Unit, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(Dimens.spacing_small)
            .clickable { onClickMovie(movie.id) },
        shape = RoundedCornerShape(4.dp),
        elevation = 4.dp
    ) {
        Column() {
            ImageCoil(
                url = movie.image,
                contentDescription = movie.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(MaterialTheme.colors.primary)
                    .padding(Dimens.spacing_small),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = movie.title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    maxLines = 2,
                    overflow = TextOverflow.Clip,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    MovieItem(movie = Movie(1, "test", "test"), {})
}