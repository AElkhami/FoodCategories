package com.elkhami.foodcategories.extensions

import android.view.View
import android.widget.ProgressBar

/**
 * Created by A.Elkhami on 18,November,2021
 */
object ViewExtensions {

    fun ProgressBar.startLoading(){
        this.visibility = View.VISIBLE
    }

    fun ProgressBar.stopLoading(){
        this.visibility = View.GONE
    }
}