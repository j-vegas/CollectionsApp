package com.jvegas.movie.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jvegas.movie.R
import com.jvegas.movie.models.ResultsItem

class ResultHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private lateinit var imagePath: String
    var movieImageView: ImageView = itemView.findViewById(R.id.movieImageView)
    var titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
    var popularityTextView: TextView = itemView.findViewById(R.id.popularityTextView)

    fun bind(result: ResultsItem) {
        imagePath = "https://image.tmdb.org/t/p/w500/" + result.posterPath
        Glide.with(itemView)
            .load(imagePath).into(movieImageView)

        titleTextView.text = result.originalTitle
        popularityTextView.text = result.popularity.toString()
    }
}