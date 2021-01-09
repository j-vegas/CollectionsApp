package com.jvegas.cryptonator.models

import androidx.room.Entity

@Entity(tableName = "change", primaryKeys = ["date", "time"])
data class Change(
    val date: String,
    val time: String,
    val changeBtcUsd: String,
    val changeBtcRub: String,
    val changeXrpUsd: String,
    val changeXrpRub: String
)