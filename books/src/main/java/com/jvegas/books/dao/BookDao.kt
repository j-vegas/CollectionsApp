package com.jvegas.books.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jvegas.books.models.Book

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg book: Book)

    @Delete
    fun delete(vararg book: Book)

    @Query("select * from book")
    fun getAll(): LiveData<List<Book>>
}