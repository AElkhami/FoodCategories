package com.elkhami.foodcategories.view.utils

import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.elkhami.foodcategories.R
import com.elkhami.foodcategories.data.other.ErrorType
import com.elkhami.foodcategories.extensions.FragmentExtensions.showSnackBar
import com.elkhami.foodcategories.extensions.ViewExtensions.startLoading
import com.elkhami.foodcategories.extensions.ViewExtensions.stopLoading

object ViewOperations {

    fun manageLoadingState(loadingProgress: ProgressBar, isLoading: Boolean) {
        if (isLoading) {
            loadingProgress.startLoading()
        } else {
            loadingProgress.stopLoading()
        }
    }

    fun onErrorReceived(fragment: Fragment, errorType: ErrorType?, message: String?) {
        when (errorType) {
            ErrorType.UnknownError -> {
                fragment.showSnackBar(fragment.getString(R.string.unknown_error_message))
            }
            ErrorType.NetworkError -> {
                fragment.showSnackBar(fragment.getString(R.string.network_error_message))
            }
            ErrorType.ResponseError -> {
                message?.let {
                    fragment.showSnackBar(it)
                }
            }
        }
    }
}