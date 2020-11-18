package com.jvegas.books.models

import androidx.room.Entity

@Entity(tableName = "book", primaryKeys = ["title", "author"])
data class Book(
    val title: String,
    val author: String,
    val price: Float,
    val rating: Float
)