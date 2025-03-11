package com.example.movieticketbookingkotlin.data.repository

import android.util.Log
import com.example.movieticketbookingkotlin.data.models.Movie
import com.example.movieticketbookingkotlin.data.remotes.RetrofitInstance
import com.example.movieticketbookingkotlin.data.responses.MovieResponse
import retrofit2.Response

class MovieRepository {
    private val apiService = RetrofitInstance.api

    suspend fun getMovies(): List<Movie>? {
        return try {
            val response: Response<MovieResponse> = apiService.getAllMovies()
            Log.d("DEBUG", "API Response: $response")
            if (response.isSuccessful) {
                Log.d("DEBUG", "Movies Data: ${response.body()?.data}")
                response.body()?.data ?: emptyList()
            } else {
                Log.e("ERROR", "API Error: ${response.errorBody()?.string()}")
                emptyList()
            }
        } catch (e: Exception) {
            Log.e("ERROR", "Exception: ${e.message}")
            emptyList()
        }
    }
}
