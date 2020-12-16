package com.jvegas.movie.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.jvegas.movie.R
import com.jvegas.movie.models.ResultsItem

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var poster: ImageView
    private lateinit var posterPath: String
    private lateinit var imagePath: String
    private lateinit var title: TextView
    private lateinit var overview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        poster = findViewById(R.id.posterImageView)
        title = findViewById(R.id.titleSingleTextView)
        overview = findViewById(R.id.overviewTextView)

        val data = intent.extras
        val result = data?.getParcelable<ResultsItem>("movieData")

        posterPath = result?.posterPath.toString()
        imagePath = "https://image.tmdb.org/t/p/w500/$posterPath"
        Glide.with(this)
            .load(imagePath)
            .placeholder(R.drawable.progress_circle)
            .into(poster)

        title.text = result?.originalTitle.toString()
        overview.text = result?.overview.toString()

//        if (intent != null && intent.hasExtra("movieData")) {
        Toast.makeText(this, result?.originalTitle.toString(), Toast.LENGTH_SHORT)
            .show()
//            }

    }
}