package com.nativepractice.advweek4160421125.view

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("android:imageUrl")
fun loadPhotoUrl(imageView: ImageView, url:String){
    val picasso = Picasso.Builder(imageView.context)
    picasso.listener { picasso, uri, exception ->exception.printStackTrace()
    }
    picasso.build().load(url).into(imageView)
}