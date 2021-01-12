package com.android.assignment.data

import androidx.annotation.DrawableRes

data class Fact(
    val title: String,
    val description: String?,
    @DrawableRes val image: Int
)
