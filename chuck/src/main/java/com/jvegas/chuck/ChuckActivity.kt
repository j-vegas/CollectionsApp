package com.jvegas.chuck

import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_chuck.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ChuckActivity : AppCompatActivity() {

    val URL = "https://api.icndb.com/jokes/random"
    var okHttpClient: OkHttpClient = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chuck)
        nextBtn.setOnClickListener {
            loadRandomFact()
        }
    }

    private fun loadRandomFact() {
        runOnUiThread {
            progressBar.visibility = View.VISIBLE
        }

        val request: Request = Request.Builder().url(URL).build()
        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
            }

            override fun onResponse(call: Call?, response: Response?) {
                val json = response?.body()?.string()
                val txt = (JSONObject(json).getJSONObject("value").get("joke")).toString()

                runOnUiThread {
                    progressBar.visibility = View.GONE
                    factTv.text = Html.fromHtml(txt)
                }
            }
        })
    }
}