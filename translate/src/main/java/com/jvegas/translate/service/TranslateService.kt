package com.jvegas.translate.service

import com.jvegas.translate.data.TranslateResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TranslateService {

    @GET("/language/translate/v2/34d4ce95f1mshddd0f833cdd5409p12a797jsnf24dc3079dab")
    fun translate(
        @Query("q") text: String,
        @Query("source") source: String,
        @Query("target") target: String
    ): Call<TranslateResult>
}