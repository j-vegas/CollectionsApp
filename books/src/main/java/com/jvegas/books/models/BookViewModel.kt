package com.jvegas.books.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jvegas.books.BookApplication
import com.jvegas.books.data.BookDatabase
import java.util.concurrent.Executors

class BookViewModel : ViewModel() {
    private val db = BookDatabase.getInstance(BookApplication.instance)
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

    fun deleteBook(book: Book) {
        service.submit {
            dao.delete(book)
        }
    }

    override fun onCleared() {
        super.onCleared()
        service.shutdown()
    }
}