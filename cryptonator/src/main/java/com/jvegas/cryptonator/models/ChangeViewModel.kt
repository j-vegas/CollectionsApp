package com.jvegas.cryptonator.models

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.jvegas.cryptonator.ChangeApplication
import com.jvegas.cryptonator.data.PriceHistoryDatabase
import java.util.concurrent.Executors

class ChangeViewModel : AndroidViewModel(ChangeApplication.instance) {
    private val db = PriceHistoryDatabase.getInstance(getApplication())
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