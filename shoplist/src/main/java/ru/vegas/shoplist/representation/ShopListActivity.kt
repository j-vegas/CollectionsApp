package ru.vegas.shoplist.representation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.vegas.shoplist.R

class ShopListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_list)
    }
}