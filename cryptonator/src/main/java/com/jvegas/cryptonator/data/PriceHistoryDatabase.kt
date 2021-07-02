package com.jvegas.cryptonator.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jvegas.cryptonator.dao.ChangeDao
import com.jvegas.cryptonator.models.Change

@Database(entities = [Change::class], version = 1, exportSchema = false)
abstract class PriceHistoryDatabase : RoomDatabase() {
    abstract fun changeDao(): ChangeDao

    companion object {
        private var INSTANCE: PriceHistoryDatabase? = null

        fun getInstance(context: Context): PriceHistoryDatabase? {
            if (INSTANCE == null) {

                synchronized(PriceHistoryDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        PriceHistoryDatabase::class.java,
                        "change.db"
                    )
                        .build()
                }
            }
            return INSTANCE
        }
    }
}