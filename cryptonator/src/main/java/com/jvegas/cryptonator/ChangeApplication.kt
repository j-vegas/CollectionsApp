package com.jvegas.cryptonator

import com.jvegas.books.BookApplication

class ChangeApplication : BookApplication() {

    companion object {
        lateinit var instance: ChangeApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}