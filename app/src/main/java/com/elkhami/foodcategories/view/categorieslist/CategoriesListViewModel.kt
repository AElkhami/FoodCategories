package com.elkhami.foodcategories.view.categorieslist

import androidx.lifecycle.ViewModel
import com.elkhami.foodcategories.data.model.FoodCategory
import com.elkhami.foodcategories.data.other.Resource
import com.elkhami.foodcategories.data.repository.FoodCategoryRepository
import com.elkhami.foodcategories.view.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class CategoriesListViewModel @Inject constructor(
    repository: FoodCategoryRepository
) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow(UiState(isLoading = true))
    var uiStateFlow = _uiStateFlow.asStateFlow()

    fun getFoodCategories() {
        TODO("Not yet implemented")
    }

}