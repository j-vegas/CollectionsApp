package com.jvegas.cryptonator.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jvegas.cryptonator.models.Change

@Dao
interface ChangeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg change: Change)

    @Query("select * from change")
    fun getAll(): LiveData<List<Change>>
}