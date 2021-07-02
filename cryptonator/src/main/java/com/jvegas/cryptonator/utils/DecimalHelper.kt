package com.jvegas.cryptonator.utils

import java.math.RoundingMode
import java.text.DecimalFormat

class DecimalHelper {

    companion object {
        fun roundOffDecimal(number: Double): String? {
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.FLOOR
            return df.format(number).toString()
        }
    }

}