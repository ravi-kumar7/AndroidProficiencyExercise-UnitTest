package com.android.assignment.data.model

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter

data class Fact(
    val title: String,
    val description: String?,
    @DrawableRes val image: Int
){

    companion object{

        @BindingAdapter("android:image")
        @JvmStatic
        fun loadImage(view: ImageView, @DrawableRes res:Int)
        {
            view.setImageResource(res)
        }
    }
}
