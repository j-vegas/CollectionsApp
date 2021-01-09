package com.jvegas.cryptonator.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class TimeUtils {

    companion object {
        @SuppressLint("SimpleDateFormat")
        val formatterDate = SimpleDateFormat("dd.MM.yyyy")

        @SuppressLint("SimpleDateFormat")
        val formatterTime = SimpleDateFormat("HH:mm:ss")

        fun getCurrentDate(): String {
            val date = Calendar.getInstance().time
            return formatterDate.format(date)
        }

        fun getCurrentTime(): String {
            val date = Calendar.getInstance().time
            return formatterTime.format(date)
        }
    }
}