package com.jvegas.books.adapters

import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jvegas.books.R
import com.jvegas.books.models.Book

class BookHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(book: Book) {
        title.text = book.title
        author.text = book.author
        rating.rating = book.rating
        price.text = book.price.toString()

    }

    var title: TextView = itemView.findViewById(R.id.title)
    var author: TextView = itemView.findViewById(R.id.author)
    var rating: RatingBar = itemView.findViewById(R.id.ratingBar)
    var price: TextView = itemView.findViewById(R.id.price)
}