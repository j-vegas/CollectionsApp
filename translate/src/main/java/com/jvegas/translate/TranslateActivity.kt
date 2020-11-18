package com.jvegas.translate

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jvegas.translate.data.TranslateResult
import com.jvegas.translate.service.TranslateService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TranslateActivity : AppCompatActivity(), View.OnClickListener, Callback<TranslateResult> {

    private lateinit var edit: EditText
    private lateinit var button: Button
    private lateinit var text: TextView

    private val baseUrl: String = "https://google-translate1.p.rapidapi.com"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(TranslateService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translate)

        edit = findViewById(R.id.edit)
        button = findViewById(R.id.button)
        text = findViewById(R.id.text)

        button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val call = service.translate(edit.text.toString(), "en", "ru")
        call.enqueue(this)
    }

    override fun onResponse(call: Call<TranslateResult>, response: Response<TranslateResult>) {
        val result = response.body()
        text.text = result.toString()
    }

    override fun onFailure(call: Call<TranslateResult>, t: Throwable) {
        Log.d("translate", "FAIL")
    }
}