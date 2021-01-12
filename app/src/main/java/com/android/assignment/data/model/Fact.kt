package com.android.assignment.data.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.android.assignment.R
import com.bumptech.glide.Glide

data class Fact(
    val title: String?,
    val description: String?,
    val imageHref:String?
){

    companion object{

        @BindingAdapter("android:src")
        @JvmStatic
        fun loadImage(view: ImageView, res:String?)
        {
            Glide.with(view.context).load(res).fitCenter().error(R.drawable.ic_image).fallback(R.drawable.ic_image).into(view)
        }
    }
}
