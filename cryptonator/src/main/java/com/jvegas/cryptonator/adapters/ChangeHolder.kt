package com.jvegas.cryptonator.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jvegas.cryptonator.R
import com.jvegas.cryptonator.models.Change

class ChangeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val date: TextView = itemView.findViewById(R.id.date)
    val time: TextView = itemView.findViewById(R.id.time)
    val changeBtcUsd: TextView = itemView.findViewById(R.id.changeBtcUsd)
    val changeBtcRub: TextView = itemView.findViewById(R.id.changeBtcRub)
    val changeXrpUsd: TextView = itemView.findViewById(R.id.changeXrpUsd)
    val changeXrpRub: TextView = itemView.findViewById(R.id.changeXrpRub)

    fun bind(change: Change) {
        date.text = change.date
        time.text = change.time
        changeBtcUsd.text = change.changeBtcUsd
        changeBtcRub.text = change.changeBtcRub
        changeXrpUsd.text = change.changeXrpUsd
        changeXrpRub.text = change.changeXrpRub
    }
}