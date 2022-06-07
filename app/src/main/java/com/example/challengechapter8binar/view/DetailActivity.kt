package com.example.challengechapter8binar.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.challengechapter8binar.model.Movie
import com.example.challengechapter8binar.view.ui.theme.ChallengeChapter8BinarTheme

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChallengeChapter8BinarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val movie = intent.getParcelableExtra<Movie>("DATAMOVIE")!!
                    DisplayDetail(movie = movie)
                }
            }
        }
    }
}

@Composable
fun DisplayDetail(movie: Movie) {
    val posterBaseUrl = "https://image.tmdb.org/t/p/w500/"
    Column(
        modifier = Modifier
            .padding(15.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Image(
                painter = rememberImagePainter(data = posterBaseUrl + movie.posterPath),
                contentDescription = "",
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Title: \n${movie.title}",
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                text = "Release date: \n${movie.releaseDate}",
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                text = "Score: \n${movie.voteAverage}",
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                text = "Overview: \n${movie.overview}",
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(bottom = 10.dp),
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview4() {
    ChallengeChapter8BinarTheme {

    }
}