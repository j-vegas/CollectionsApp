package com.jvegas.cryptonator

import android.os.Bundle
import android.util.Log
import android.view.View
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

class CryptonatorActivity : AppCompatActivity(), View.OnClickListener, Callback<CryptoResult> {

    private lateinit var buttonBtcUsd: Button
    private lateinit var buttonBtcRub: Button
    private lateinit var resultText: TextView
    private lateinit var resultText2: TextView

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
        resultText = findViewById(R.id.result)

        buttonBtcRub = findViewById(R.id.btcRub)
        resultText2 = findViewById(R.id.result2)

        buttonBtcUsd.setOnClickListener(this)
        buttonBtcRub.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
//        val call = services.btcUsd("BTC", "USD")
        val call = services.btcUsd()
        call.enqueue(this)

        val call2 = services.btcRub()
        call2.enqueue(this)
    }

    override fun onResponse(call: Call<CryptoResult>, response: Response<CryptoResult>) {
        val result = response.body()
        resultText.text = result!!.ticker.price

        val result2 = response.body()
        resultText2.text = result2!!.ticker.price
    }

    override fun onFailure(call: Call<CryptoResult>, t: Throwable) {
        Log.d("btcUsd", "FAIL")
    }
}