package com.jvegas.collectionsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.jvegas.chuck.ChuckActivity

class MainActivity : AppCompatActivity() {

    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.chuckApp)
        button.setOnClickListener { view ->
            val intent = Intent(this, ChuckActivity::class.java)
            startActivity(intent)
        }
    }
}