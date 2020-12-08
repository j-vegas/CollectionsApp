package com.jvegas.translate.service

import com.jvegas.translate.data.TranslateResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TranslateService {

    @GET("/language/translate/")
    fun translate(
        @Query("q") text: String,
        @Query("source") source: String,
        @Query("target") target: String
    ): Call<TranslateResult>
}