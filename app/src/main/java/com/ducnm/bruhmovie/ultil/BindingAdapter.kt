package com.ducnm.bruhmovie.ultil

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter(
    value = ["glideImageUrl"]
)
fun ImageView.LoadImage(
    url: String?,
){
    Glide.with(context)
        .load(url)
        .into(this)
}