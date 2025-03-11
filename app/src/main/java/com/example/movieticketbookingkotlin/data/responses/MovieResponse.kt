package com.example.movieticketbookingkotlin.data.responses

import com.example.movieticketbookingkotlin.data.models.Movie

data class MovieResponse(
    val message: String,
    val status: String,
    val data: List<Movie>
)


