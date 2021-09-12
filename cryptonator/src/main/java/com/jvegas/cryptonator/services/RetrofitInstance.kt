package com.jvegas.cryptonator.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class RetrofitInstance {
    companion object {
        private val BASE_URL: String = "https://api.cryptonator.com"

        fun getService(): CryptoServices {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(CryptoServices::class.java)
        }
    }
}