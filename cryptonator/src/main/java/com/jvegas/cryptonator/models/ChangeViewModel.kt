package com.jvegas.cryptonator.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jvegas.cryptonator.ChangeApplication
import com.jvegas.cryptonator.data.PriceHistoryDatabase
import java.util.concurrent.Executors

class ChangeViewModel : ViewModel() {
    private val db = PriceHistoryDatabase.getInstance(ChangeApplication.instance)
    private val dao = db!!.changeDao()
    private val service = Executors.newFixedThreadPool(1)

    fun getAll(): LiveData<List<Change>> {
        return dao.getAll()
    }

    fun addChangePrice(change: Change) {
        service.submit {
            dao.insert(change)
        }
    }

    override fun onCleared() {
        super.onCleared()
        service.shutdown()
    }
}