package com.jvegas.cryptonator.services

import com.jvegas.cryptonator.data.CryptoResult
import retrofit2.Call
import retrofit2.http.GET

interface CryptoServices {

    @GET("/api/ticker/btc-usd")
    fun btcUsd(): Call<CryptoResult>

    @GET("/api/ticker/btc-rub")
    fun btcRub(): Call<CryptoResult>
}