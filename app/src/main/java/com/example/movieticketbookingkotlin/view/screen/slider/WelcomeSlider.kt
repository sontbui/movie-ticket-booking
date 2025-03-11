package com.example.movieticketbookingkotlin.view.screen.slider

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.movieticketbookingkotlin.R
import com.example.movieticketbookingkotlin.viewmodel.MovieViewModel
import com.google.accompanist.pager.*
import kotlinx.coroutines.time.delay
import java.time.Duration


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeSlide(viewModel: MovieViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val movies by viewModel.movies.collectAsState(initial = emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchMovies()
    }

    val pagerState = rememberPagerState()

    LaunchedEffect(Unit) {
        while (true) {
            delay(Duration.ofMillis(4500))
            println("\n" + movies.toString())

            if (movies.isNotEmpty()) {
                val nextPage = (pagerState.currentPage + 1) % movies.size
                pagerState.animateScrollToPage(nextPage)
            }
        }
    }

    if(movies.isEmpty()){
        LazyColumn {
            items(movies) { movie ->
                Text(text = movie.title["vi"] ?: "Không có tiêu đề")
            }
        }
    }
    if (movies.isNotEmpty()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(
                count = movies.size,
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp)
            ) { page ->
                val movie = movies[page]
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    AsyncImage(
                        model = movie.posterUrl,
                        contentDescription = movie.title["vi"] ?: "Movie Poster",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(350.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = movie.title["vi"] ?: "No title",
                        color = Color.White,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}
