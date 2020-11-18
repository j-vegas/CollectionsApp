package com.jvegas.books.models

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.jvegas.books.BookApplication
import com.jvegas.books.data.BookDatabase
import java.util.concurrent.Executors

class BookViewModel : AndroidViewModel(BookApplication.instance) {
    private val db = BookDatabase.getInstance(getApplication())
    private val dao = db!!.bookDao()
    private val service = Executors.newFixedThreadPool(1)

    fun getAll(): LiveData<List<Book>> {
        return dao.getAll()
    }

    fun addBook(book: Book) {
        service.submit {
            dao.insert(book)
        }
    }

    override fun onCleared() {
        super.onCleared()
        service.shutdown()
    }
}