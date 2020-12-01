package com.jvegas.cryptonator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jvegas.cryptonator.data.CryptoResult
import com.jvegas.cryptonator.services.CryptoServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CryptonatorActivity : AppCompatActivity() {

    private lateinit var buttonBtcUsd: Button
    private lateinit var buttonBtcRub: Button
    private lateinit var resultTextUsd: TextView
    private lateinit var resultTextRu: TextView

    private val baseUrl: String = "https://api.cryptonator.com"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val services = retrofit.create(CryptoServices::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cryptonator)

        buttonBtcUsd = findViewById(R.id.btcUsd)
        resultTextUsd = findViewById(R.id.result)

        buttonBtcRub = findViewById(R.id.btcRub)
        resultTextRu = findViewById(R.id.result2)

        buttonBtcUsd.setOnClickListener { loadPriceBtnUsd() }
        buttonBtcRub.setOnClickListener { loadPriceBtnRub() }
    }

    private fun loadPriceBtnRub() {
        services.btcRub().enqueue(object : Callback<CryptoResult> {
            override fun onResponse(call: Call<CryptoResult>, response: Response<CryptoResult>) {
                val result = response.body()
                resultTextRu.text = result!!.ticker.price
            }

            override fun onFailure(call: Call<CryptoResult>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun loadPriceBtnUsd() {
        services.btcUsd().enqueue(object : Callback<CryptoResult> {
            override fun onResponse(call: Call<CryptoResult>, response: Response<CryptoResult>) {
                val result = response.body()
                resultTextUsd.text = result!!.ticker.price
            }

            override fun onFailure(call: Call<CryptoResult>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

}