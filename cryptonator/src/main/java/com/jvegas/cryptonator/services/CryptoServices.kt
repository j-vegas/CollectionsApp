package com.jvegas.cryptonator.services

import com.jvegas.cryptonator.data.CryptoResult
import com.jvegas.cryptonator.data.Ticker
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoServices {

    @GET("/api/ticker/btc-usd")
    fun btcUsd(
//        @Query("price") price: String,
//        @Query("base") base: String,
//        @Query("target") target: String
    ): Call<CryptoResult>

    @GET("/api/ticker/btc-rub")
    fun btcRub(): Call<CryptoResult>
}