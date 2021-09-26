package com.jvegas.cryptonator

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jvegas.cryptonator.adapters.ChangeAdapter
import com.jvegas.cryptonator.data.CryptoResult
import com.jvegas.cryptonator.databinding.ActivityCryptonatorBinding
import com.jvegas.cryptonator.models.Change
import com.jvegas.cryptonator.models.ChangeViewModel
import com.jvegas.cryptonator.services.RetrofitInstance.Companion.getService
import com.jvegas.cryptonator.utils.DecimalHelper.Companion.roundOffDecimal
import com.jvegas.cryptonator.utils.TimeUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CryptonatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCryptonatorBinding
    private val model: ChangeViewModel by viewModels()

    init {
        loadPriceAll()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCryptonatorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        model.getAll().observe(this, Observer<List<Change>> {
            val adapter = ChangeAdapter(it)
            binding.changeList.adapter = adapter
        })

        val layout = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, layout.orientation)

        binding.changeList.layoutManager = layout
        binding.changeList.addItemDecoration(decoration)

        binding.btcUsd.setOnClickListener { loadPriceBtnUsd() }
        binding.btcRub.setOnClickListener { loadPriceBtnRub() }
        binding.xrpUsd.setOnClickListener { loadPriceXrpUsd() }
        binding.xrpRub.setOnClickListener { loadPriceXrpRub() }
        binding.showAll.setOnClickListener { loadPriceAll() }
        binding.addInHistory.setOnClickListener { _ ->
            val change = Change(
                TimeUtils.getCurrentDate(),
                TimeUtils.getCurrentTime(),
                binding.resultBtcUsd.text.toString(),
                binding.resultBtcRub.text.toString(),
                binding.resultXrpUsd.text.toString(),
                binding.resultXrpRub.text.toString()
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
        getService().btcRub().enqueue(object : Callback<CryptoResult> {
            override fun onResponse(call: Call<CryptoResult>, response: Response<CryptoResult>) {
                val result = response.body()
                binding.resultBtcRub.text = roundOffDecimal(result!!.ticker.price.toDouble())
            }

            override fun onFailure(call: Call<CryptoResult>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun loadPriceBtnUsd() {
        getService().btcUsd().enqueue(object : Callback<CryptoResult> {
            override fun onResponse(call: Call<CryptoResult>, response: Response<CryptoResult>) {
                val result = response.body()
                binding.resultBtcUsd.text = roundOffDecimal(result!!.ticker.price.toDouble())
            }

            override fun onFailure(call: Call<CryptoResult>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun loadPriceXrpRub() {
        getService().xrpRub().enqueue(object : Callback<CryptoResult> {
            override fun onResponse(call: Call<CryptoResult>, response: Response<CryptoResult>) {
                val result = response.body()
                binding.resultXrpRub.text = roundOffDecimal(result!!.ticker.price.toDouble())
            }

            override fun onFailure(call: Call<CryptoResult>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun loadPriceXrpUsd() {
        getService().xrpUsd().enqueue(object : Callback<CryptoResult> {
            override fun onResponse(call: Call<CryptoResult>, response: Response<CryptoResult>) {
                val result = response.body()
                binding.resultXrpUsd.text = roundOffDecimal(result!!.ticker.price.toDouble())
            }

            override fun onFailure(call: Call<CryptoResult>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}