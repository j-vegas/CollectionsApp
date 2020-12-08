package com.jvegas.cryptonator

import android.app.Application

class ChangeApplication : Application() {

    companion object {
        lateinit var instance: ChangeApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}