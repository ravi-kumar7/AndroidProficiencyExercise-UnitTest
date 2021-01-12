package com.android.assignment.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.assignment.R

class FactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val headingTextView:TextView = itemView.findViewById(R.id.tv_article_title)
    private val descriptionTextView:TextView = itemView.findViewById(R.id.tv_article_description)
    private val factImage: ImageView = itemView.findViewById(R.id.iv_article)
}