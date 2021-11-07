package com.elkhami.foodcategories.view.categorieslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elkhami.foodcategories.data.other.Resource
import com.elkhami.foodcategories.data.other.Status
import com.elkhami.foodcategories.data.repository.FoodCategoryRepository
import com.elkhami.foodcategories.view.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CategoriesListViewModel @Inject constructor(
    private val repository: FoodCategoryRepository
) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow(UiState(isLoading = false))
    var uiStateFlow = _uiStateFlow.asStateFlow()

    init {
        getFoodCategories()
    }

    fun getFoodCategories() {

        Resource.Loading(null)

        viewModelScope.launch {
            val response = repository.getFoodCategories()
            when (response.status) {
                Status.SUCCESS -> {
                    response.data?.let { foodCategories ->
                        _uiStateFlow.value =
                            UiState(
                                foodCategories = foodCategories,
                                isLoading = false
                            )
                    }
                }
                Status.FAILED -> {
                    _uiStateFlow.value = UiState(
                        errorType = response.errorType,
                        message = response.message,
                        isLoading = false
                    )
                }
                Status.LOADING -> {
                    _uiStateFlow.value = UiState(isLoading = true)
                }
            }
        }
    }

}