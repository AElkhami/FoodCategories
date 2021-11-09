package com.elkhami.foodcategories.extensions

import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

/**
 * Created by A.Elkhami on 08,November,2021
 */
object FragmentExtensions {

    fun Fragment.startLoading(progressBar: ProgressBar){
        progressBar.visibility = View.VISIBLE
    }

    fun Fragment.stopLoading(progressBar: ProgressBar){
        progressBar.visibility = View.GONE
    }

    fun Fragment.showSnackBar(message: String){
        Snackbar.make(this.requireView(), message, Snackbar.LENGTH_LONG).show()
    }
}