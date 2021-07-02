package com.jvegas.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jvegas.books.adapters.BooksAdapter
import com.jvegas.books.helpers.SwipeHelper
import com.jvegas.books.models.Book
import com.jvegas.books.models.BookViewModel

class BookActivity : AppCompatActivity() {

    private lateinit var list: RecyclerView
    private lateinit var toast: Toast
    private lateinit var model: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        list = findViewById(R.id.list)

        model = ViewModelProvider(this).get(BookViewModel::class.java)

        model.getAll().observe(this, Observer<List<Book>> {
            val a = BooksAdapter(it)
            list.adapter = a
        })

        val layout = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, layout.orientation)

        list.layoutManager = layout
        list.addItemDecoration(decoration)
        setUpRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.main_add -> {
                showAddDialog()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun showAddDialog() {
        val view = LayoutInflater.from(this)
            .inflate(R.layout.add_book_dialog, null)

        val title = view.findViewById<EditText>(R.id.title)
        val author = view.findViewById<EditText>(R.id.author)
        val price = view.findViewById<EditText>(R.id.price)
        val rating = view.findViewById<RatingBar>(R.id.rating)

        val builder = AlertDialog.Builder(this)
        builder.setView(view)
        builder.setTitle("Create a book")

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.cancel()
        }

        builder.setPositiveButton("Add") { dialog, _ ->
            val book = Book(
                title.text.toString(),
                author.text.toString(),
                price.text.toString().toFloat(),
                rating.rating
            )
            model.addBook(book)

            dialog.dismiss()
        }

        builder.create().show()
    }

    private fun setUpRecyclerView() {

        val itemTouchHelper = ItemTouchHelper(object : SwipeHelper(list) {
            override fun instantiateUnderlayButton(position: Int): List<UnderlayButton> {
                var buttons = listOf<UnderlayButton>()
                val deleteButton = deleteButton(position)
                when (position) {
                    position -> buttons = listOf(deleteButton)
                }
                return buttons
            }
        })

        itemTouchHelper.attachToRecyclerView(list)
    }

    private fun toast(text: String) {
        toast.cancel()
        toast = Toast.makeText(this, text, Toast.LENGTH_SHORT)
        toast.show()
    }

    private fun deleteButton(position: Int): SwipeHelper.UnderlayButton {
        return SwipeHelper.UnderlayButton(
            this,
            "Delete",
            14.0f,
            android.R.color.holo_red_light,
            object : SwipeHelper.UnderlayButtonClickListener {
                override fun onClick() {
                    toast("Deleted item $position")
                    // todo сделать удаление книги из list
//                    model.deleteBook(book)
                }
            })
    }
}