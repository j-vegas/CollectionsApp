package com.jvegas.cryptonator.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jvegas.cryptonator.R
import com.jvegas.cryptonator.models.Change

class ChangeAdapter(val changes: List<Change>) : RecyclerView.Adapter<ChangeHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChangeHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.coin_change, parent, false)
        return ChangeHolder(view)
    }

    override fun onBindViewHolder(holder: ChangeHolder, position: Int) {
        val change = changes[position]
        holder.bind(change)
    }

    override fun getItemCount(): Int {
        return changes.size
    }
}