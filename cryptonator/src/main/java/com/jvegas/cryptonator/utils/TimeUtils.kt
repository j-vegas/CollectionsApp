package com.jvegas.cryptonator.utils

import java.text.SimpleDateFormat
import java.util.*

class TimeUtils {

    companion object {
        val formatterDate = SimpleDateFormat("dd.MM.yyyy")
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