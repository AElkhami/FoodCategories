package com.elkhami.foodcategories.view

import com.elkhami.foodcategories.data.model.FoodCategory
import com.elkhami.foodcategories.data.other.ErrorType

/**
 * Created by A.Elkhami on 07,November,2021
 */
data class UiState(
    val foodCategories: List<FoodCategory> = listOf(),
    val errorType: ErrorType? = null,
    val message: String? = null,
    val isLoading: Boolean = false
)