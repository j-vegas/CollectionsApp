package com.jvegas.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jvegas.movie.models.MovieApiResponse
import com.jvegas.movie.services.MovieApiServices
import com.jvegas.movie.services.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        getPopularMovies()
    }

    private fun getPopularMovies() {
        val movieApiServices: MovieApiServices = RetrofitInstance.getService()

        val call: Call<MovieApiResponse> =
            movieApiServices.getPopularMovies(getString(R.string.api_key))
        call.enqueue(object : Callback<MovieApiResponse> {
            override fun onResponse(
                call: Call<MovieApiResponse>,
                response: Response<MovieApiResponse>
            ) {
                val movieApiResponse: MovieApiResponse? =
                    response.body()
            }

            override fun onFailure(call: Call<MovieApiResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}