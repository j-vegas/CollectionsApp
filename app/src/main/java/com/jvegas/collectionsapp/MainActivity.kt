package com.jvegas.collectionsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.jvegas.books.BookActivity
import com.jvegas.chuck.ChuckActivity
import com.jvegas.cryptonator.CryptonatorActivity
import com.jvegas.movie.MovieActivity
import com.jvegas.translate.TranslateActivity

class MainActivity : AppCompatActivity() {

    private lateinit var chuckApp: Button
    private lateinit var booksApp: Button
    private lateinit var translateApp: Button
    private lateinit var cryptonatorApp: Button
    private lateinit var movieApp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chuckApp = findViewById(R.id.chuckApp)
        chuckApp.setOnClickListener { view ->
            val intent = Intent(this, ChuckActivity::class.java)
            startActivity(intent)
        }

        booksApp = findViewById(R.id.booksApp)
        booksApp.setOnClickListener { view ->
            val intent = Intent(this, BookActivity::class.java)
            startActivity(intent)
        }

        translateApp = findViewById(R.id.translateApp)
        translateApp.setOnClickListener { view ->
            val intent = Intent(this, TranslateActivity::class.java)
            startActivity(intent)
        }

        cryptonatorApp = findViewById(R.id.cryptonatorApp)
        cryptonatorApp.setOnClickListener { view ->
            val intent = Intent(this, CryptonatorActivity::class.java)
            startActivity(intent)
        }

        movieApp = findViewById(R.id.movieApp)
        movieApp.setOnClickListener { view ->
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }
    }
}