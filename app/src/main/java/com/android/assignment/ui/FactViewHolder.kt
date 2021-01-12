package com.android.assignment.ui

import androidx.recyclerview.widget.RecyclerView
import com.android.assignment.data.model.Fact
import com.android.assignment.databinding.LayoutRowItemBinding

class FactViewHolder(private val binding: LayoutRowItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(fact: Fact){
        binding.fact = fact
    }
}