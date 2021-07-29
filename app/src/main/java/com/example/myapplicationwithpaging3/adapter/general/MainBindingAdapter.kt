package com.example.myapplicationwithpaging3.adapter.general

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import coil.load

import coil.size.Scale
import com.example.myapplicationwithpaging3.R

class MainBindingAdapter {

    companion object {
        /*@JvmStatic
        @BindingAdapter("setImgUrl")
        fun setImgUrl(imageView: AppCompatImageView, imgeUrl: String) {
            Glide.with(imageView.context).load(imgeUrl).into(imageView)
        }*/

        @JvmStatic
        @BindingAdapter("setImage")
        fun setImage(imageView: AppCompatImageView, imgeUrl: String) {
            imageView.load(imgeUrl)
            {
                placeholder(R.drawable.no_image_found)
                crossfade(true)
                scale(Scale.FIT)
            }
        }

        @JvmStatic
        @BindingAdapter("setText")
        fun setText(textView: AppCompatTextView, value: String) {
            textView.text = value
        }

    }
}