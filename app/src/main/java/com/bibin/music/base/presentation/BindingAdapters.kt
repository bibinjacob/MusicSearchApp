package com.bibin.music.base.presentation

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bibin.music.musicmanagement.presentation.entity.Image
import com.bumptech.glide.Glide

@BindingAdapter("visible")
fun setProgressBarVisibility(view: View, status: Status?) {
    view.visibility = if (status == Status.Loading) View.VISIBLE else View.GONE
}

@BindingAdapter("setSmallImage")
fun setSmallImage(view: ImageView, images: List<Image>?) {

    Glide.with(view.context)
        .load(getImageUrlBasedOnSize(images, "small"))
        .into(view)
}

@BindingAdapter("setExtraLargeImage")
fun setExtraLargeImage(view: View, images: List<Image>?) {
    getImageUrlBasedOnSize(images, "extralarge")
}