package com.jvegas.cryptonator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jvegas.cryptonator.adapters.ChangeAdapter
import com.jvegas.cryptonator.data.CryptoResult
import com.jvegas.cryptonator.models.Change
import com.jvegas.cryptonator.models.ChangeViewModel
import com.jvegas.cryptonator.services.CryptoServices
import com.jvegas.cryptonator.utils.DecimalHelper.Companion.roundOffDecimal
import com.jvegas.cryptonator.utils.TimeUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CryptonatorActivity : AppCompatActivity() {

    private lateinit var changeList: RecyclerView
    private lateinit var model: ChangeViewModel

    private lateinit var buttonBtcUsd: Button
    private lateinit var buttonBtcRub: Button
    private lateinit var buttonXrpUsd: Button
    private lateinit var buttonXrpRub: Button
    private lateinit var buttonAll: Button
    private lateinit var addInHistoryBtn: Button

    private lateinit var resultTextUsd: TextView
    private lateinit var resultTextRu: TextView
    private lateinit var resultTextXrpUsd: TextView
    private lateinit var resultTextXrpRub: TextView

    var changeBtcUsd: TextView? = null

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
        resultTextUsd = findViewById(R.id.resultBtcUsd)

        buttonBtcRub = findViewById(R.id.btcRub)
        resultTextRu = findViewById(R.id.resultBtcRub)

        buttonXrpUsd = findViewById(R.id.xrpUsd)
        resultTextXrpUsd = findViewById(R.id.resultXrpUsd)

        buttonXrpRub = findViewById(R.id.xrpRub)
        resultTextXrpRub = findViewById(R.id.resultXrpRub)

        buttonAll = findViewById(R.id.showAll)

        addInHistoryBtn = findViewById(R.id.addInHistory)

        changeList = findViewById(R.id.changeList)

        changeBtcUsd = findViewById(R.id.changeBtcUsd)

        model = ViewModelProvider(this).get(ChangeViewModel::class.java)

        model.getAll().observe(this, Observer<List<Change>> {
            val adapter = ChangeAdapter(it)
            changeList.adapter = adapter
        })

        val layout = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, layout.orientation)

        changeList.layoutManager = layout
        changeList.addItemDecoration(decoration)

        buttonBtcUsd.setOnClickListener { loadPriceBtnUsd() }
        buttonBtcRub.setOnClickListener { loadPriceBtnRub() }
        buttonXrpUsd.setOnClickListener { loadPriceXrpUsd() }
        buttonXrpRub.setOnClickListener { loadPriceXrpRub() }
        buttonAll.setOnClickListener { loadPriceAll() }
        addInHistoryBtn.setOnClickListener { _ ->
            val change = Change(
                TimeUtils.getCurrentDate(),
                TimeUtils.getCurrentTime(),
                resultTextUsd.text.toString(),
                resultTextRu.text.toString(),
                resultTextXrpUsd.text.toString(),
                resultTextXrpRub.text.toString()
            )
            model.addChangePrice(change)
        }
    }

    private fun loadPriceAll() {
        loadPriceBtnUsd()
        loadPriceBtnRub()
        loadPriceXrpUsd()
        loadPriceXrpRub()
    }

    private fun loadPriceBtnRub() {
        services.btcRub().enqueue(object : Callback<CryptoResult> {
            override fun onResponse(call: Call<CryptoResult>, response: Response<CryptoResult>) {
                val result = response.body()
                resultTextRu.text = roundOffDecimal(result!!.ticker.price.toDouble())
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
                resultTextUsd.text = roundOffDecimal(result!!.ticker.price.toDouble())
            }

            override fun onFailure(call: Call<CryptoResult>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun loadPriceXrpRub() {
        services.xrpRub().enqueue(object : Callback<CryptoResult> {
            override fun onResponse(call: Call<CryptoResult>, response: Response<CryptoResult>) {
                val result = response.body()
                resultTextXrpRub.text = roundOffDecimal(result!!.ticker.price.toDouble())
            }

            override fun onFailure(call: Call<CryptoResult>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun loadPriceXrpUsd() {
        services.xrpUsd().enqueue(object : Callback<CryptoResult> {
            override fun onResponse(call: Call<CryptoResult>, response: Response<CryptoResult>) {
                val result = response.body()
                resultTextXrpUsd.text = roundOffDecimal(result!!.ticker.price.toDouble())
            }

            override fun onFailure(call: Call<CryptoResult>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}