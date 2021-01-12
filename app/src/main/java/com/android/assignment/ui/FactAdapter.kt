package com.android.assignment.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.assignment.R
import com.android.assignment.data.Fact

class FactAdapter(private val data: ArrayList<Fact>) : RecyclerView.Adapter<FactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FactViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.layout_row_item, parent, false)
    )

    override fun onBindViewHolder(holder: FactViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size
}