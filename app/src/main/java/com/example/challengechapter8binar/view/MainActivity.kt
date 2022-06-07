package com.example.challengechapter8binar.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.challengechapter8binar.R
import com.example.challengechapter8binar.model.Movie
import com.example.challengechapter8binar.ui.theme.ChallengeChapter8BinarTheme
import com.example.challengechapter8binar.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ChallengeChapter8BinarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val viewModelMovie = viewModel(modelClass = MovieViewModel::class.java)
                    val dataMovie by viewModelMovie.dataMovieState.collectAsState()
                    //val mContext = LocalContext.current
                    Column(modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize()) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Image(
                                painterResource(id = R.drawable.ic_baseline_person_24),
                                contentDescription = "",
                                modifier = Modifier
                                    .clickable {
//                                    mContext.startActivity(
//                                        Intent(
//                                            mContext,
//                                            StafListActivity::class.java
//                                        )
//                                    )
                                    }
                            )
                            Text(
                                text = "Hello, username",
                                color = Color.Black,
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                            Text(
                                text = "LOGOUT",
                                color = Color.Black,
                                textAlign = TextAlign.End,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.CenterVertically)
                            )
                        }

                        LazyColumn {
                            if (dataMovie.isEmpty()) {
                                item {
                                }
                            } else {
                                items(dataMovie) {
                                    DisplayFilmList(movie = it)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DisplayFilmList(movie: Movie) {
    val posterBaseUrl = "https://image.tmdb.org/t/p/w500/"
    val mContext = LocalContext.current
    Column(modifier = Modifier.padding(20.dp)) {
        Card(
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clickable {
                    val intent = Intent(mContext, DetailActivity::class.java)
                    intent.putExtra("DATAMOVIE", movie)
                    mContext.startActivity(intent)
                }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Gray)
            ) {
                Image(
                    painter = rememberImagePainter(data = posterBaseUrl + movie.posterPath),
                    contentDescription = "",
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
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
                        text = "Skor: \n${movie.voteAverage}",
                        color = Color.Black,
                        fontWeight = FontWeight.Normal
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ChallengeChapter8BinarTheme {

    }
}