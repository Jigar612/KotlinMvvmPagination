package com.example.myapplicationwithpaging3.helper

import android.content.Context
import android.content.res.ColorStateList
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.myapplicationwithpaging3.R
import com.example.myapplicationwithpaging3.util.AppConstant

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

/*
fun ViewGroup.inflate(layoutId: Int): ViewDataBinding {
    return DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, this, false)
}
*/

fun Button.backgroundColor(colors: AppConstant.COLORS) {

    when (colors) {

        AppConstant.COLORS.White -> {
            this.backgroundTintList =
                ColorStateList.valueOf(this.context.resources.getColor(R.color.white))
        }

        AppConstant.COLORS.Red -> {
            this.backgroundTintList =
                ColorStateList.valueOf(this.context.resources.getColor(R.color.red))
        }

        AppConstant.COLORS.Blue -> {
            this.backgroundTintList =
                ColorStateList.valueOf(this.context.resources.getColor(R.color.blue))
        }
    }
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}