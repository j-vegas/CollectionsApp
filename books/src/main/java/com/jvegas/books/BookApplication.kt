package com.jvegas.books

import android.app.Application

open class BookApplication : Application() {

    companion object {
        lateinit var instance: BookApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}