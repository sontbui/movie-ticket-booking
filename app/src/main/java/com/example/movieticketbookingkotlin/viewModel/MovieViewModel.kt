package com.example.movieticketbookingkotlin.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieticketbookingkotlin.data.models.Movie
import com.example.movieticketbookingkotlin.data.repository.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val _movies = MutableLiveData<List<Movie>?>()  // LiveData lưu danh sách phim
    val movies: MutableLiveData<List<Movie>?> = _movies  // Expose LiveData để sử dụng bên ngoài

    private val repository = MovieRepository() // Khởi tạo repository

    fun fetchMovies() {
        viewModelScope.launch {
            val movieList = repository.getMovies() // Gọi phương thức từ repository
            Log.d("DEBUG", "Movies in ViewModel: $movieList")
            _movies.postValue(movieList) // Cập nhật LiveData
        }
    }
}
