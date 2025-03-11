package com.example.movieticketbookingkotlin.data.remotes

import com.example.movieticketbookingkotlin.data.responses.MovieResponse
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Response

interface MovieApiService {
    @GET("movies/getAll")
    suspend fun getAllMovies(): Response<MovieResponse>
}
