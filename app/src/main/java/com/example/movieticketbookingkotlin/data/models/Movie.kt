package com.example.movieticketbookingkotlin.data.models

import kotlinx.serialization.Serializable

@Serializable
data class  MovieId(
    val timeStamp: Long,
    val date: String
)
@Serializable
data class Movie(
    val id: MovieId,
    val title: Map<String, String>,
    val duration: Int,
    val posterUrl: String,
    val description: Map<String, String>,
    val releaseDate: String,
    val characters: List<Character>,
    val genre: List<String>?
)
