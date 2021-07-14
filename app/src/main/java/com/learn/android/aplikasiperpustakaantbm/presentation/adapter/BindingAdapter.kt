package com.learn.android.aplikasiperpustakaantbm.presentation.adapter

import android.graphics.Bitmap
import android.widget.ImageButton
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation

@BindingAdapter("loadImageView")
fun ImageView.loadImageFromDB(bitmap: Bitmap) {
    this.load(bitmap)
}

@BindingAdapter("loadButtonImage")
fun ImageButton.loadImageFromDB(bitmap: Bitmap) {
    this.load(bitmap) {
        crossfade(true)
        crossfade(1000)
        transformations(CircleCropTransformation())
    }
}