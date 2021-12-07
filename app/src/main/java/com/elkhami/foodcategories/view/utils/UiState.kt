package com.elkhami.foodcategories.view.utils

import com.elkhami.foodcategories.data.other.ErrorType

/**
 * Created by A.Elkhami on 07,November,2021
 */
data class UiState<T>(
    var data: T? = null,
    var errorType: ErrorType? = null,
    var message: String? = null,
    var isLoading: Boolean = false
)