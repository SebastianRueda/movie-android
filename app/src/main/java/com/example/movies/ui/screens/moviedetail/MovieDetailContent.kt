package com.example.movies.ui.screens.moviedetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.movies.data.entities.MovieDetail
import com.example.movies.ui.components.ImageCoil
import com.example.movies.ui.theme.Dimens
import com.example.movies.ui.theme.Typography

@Composable
fun MovieDetailContent(movieDetail: MovieDetail, onClickBack: () -> Unit) {
    Column (modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = movieDetail.title) },
            navigationIcon = {
                IconButton(onClick = onClickBack) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            },
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(Dimens.spacing_medium),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Card(
                modifier = Modifier
                    .width(240.dp)
                    .height(320.dp),
                elevation = 4.dp,
                shape = RoundedCornerShape(8.dp)
            ) {
                ImageCoil(
                    movieDetail.image,
                    movieDetail.title,
                    Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = movieDetail.title,
                style = Typography.h6,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = movieDetail.overview,
                style = Typography.body1,
                textAlign = TextAlign.Center
            )
        }
    }
}