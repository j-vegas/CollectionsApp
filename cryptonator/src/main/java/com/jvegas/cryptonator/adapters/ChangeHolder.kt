package com.jvegas.cryptonator.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jvegas.cryptonator.R
import com.jvegas.cryptonator.models.Change

class ChangeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var date: TextView = itemView.findViewById(R.id.date)
    var time: TextView = itemView.findViewById(R.id.time)
    var changeBtcUsd: TextView = itemView.findViewById(R.id.changeBtcUsd)

    fun bind(change: Change) {
        date.text = change.date.toString()
        time.text = change.time.toString()
        changeBtcUsd.text = change.changeBtcUsd.toString()
    }
}