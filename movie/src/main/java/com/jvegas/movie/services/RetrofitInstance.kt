package com.jvegas.movie.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        private val BASE_URL: String = "https://api.themoviedb.org/3/"

        fun getService(): MovieApiServices {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(MovieApiServices::class.java)
        }
    }
}