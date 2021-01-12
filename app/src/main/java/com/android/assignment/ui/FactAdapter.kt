package com.android.assignment.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.assignment.data.model.Fact
import com.android.assignment.databinding.LayoutRowItemBinding

class FactAdapter(private val data: ArrayList<Fact>) : RecyclerView.Adapter<FactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FactViewHolder(
        LayoutRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: FactViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size
}