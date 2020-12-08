package com.jvegas.movie.services

import com.jvegas.movie.models.MovieApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiServices {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String
    ): Call<MovieApiResponse>
}