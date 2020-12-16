package com.jvegas.movie.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jvegas.movie.R
import com.jvegas.movie.models.ResultsItem
import com.jvegas.movie.view.MovieDetailsActivity

class ResultAdapter(val results: List<ResultsItem>) : RecyclerView.Adapter<ResultHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.result_list_item, parent, false)
        return ResultHolder(view)
    }

    override fun onBindViewHolder(holder: ResultHolder, position: Int) {
        val movieItem = results[position]
        holder.bind(movieItem)

        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(v?.context, MovieDetailsActivity::class.java)
                intent.putExtra("movieData", movieItem)
                v?.context?.startActivity(intent)
            }
        })
    }

    override fun getItemCount(): Int {
        return results.size
    }
}