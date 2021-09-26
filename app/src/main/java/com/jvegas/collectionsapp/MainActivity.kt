package com.jvegas.collectionsapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jvegas.books.BookActivity
import com.jvegas.chuck.ChuckActivity
import com.jvegas.collectionsapp.databinding.ActivityMainBinding
import com.jvegas.cryptonator.CryptonatorActivity
import com.jvegas.movie.MovieActivity
import com.jvegas.translate.TranslateActivity
import ru.vegas.shoplist.representation.ShopListActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.chuckApp.setOnClickListener { _ ->
            val intent = Intent(this, ChuckActivity::class.java)
            startActivity(intent)
        }

        binding.booksApp.setOnClickListener { _ ->
            val intent = Intent(this, BookActivity::class.java)
            startActivity(intent)
        }

        binding.translateApp.setOnClickListener { _ ->
            val intent = Intent(this, TranslateActivity::class.java)
            startActivity(intent)
        }

        binding.cryptonatorApp.setOnClickListener { _ ->
            val intent = Intent(this, CryptonatorActivity::class.java)
            startActivity(intent)
        }

        binding.movieApp.setOnClickListener { _ ->
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.shoplistApp.setOnClickListener { _ ->
            val intent = Intent(this, ShopListActivity::class.java)
            startActivity(intent)
        }
    }
}