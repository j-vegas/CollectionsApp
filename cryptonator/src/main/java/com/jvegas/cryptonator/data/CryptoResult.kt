package com.jvegas.cryptonator.data

data class CryptoResult(
    val error: String,
    val success: Boolean,
    val ticker: Ticker,
    val timestamp: Int
)