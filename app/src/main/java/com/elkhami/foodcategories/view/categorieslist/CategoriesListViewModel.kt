package com.elkhami.foodcategories.view.categorieslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elkhami.foodcategories.BuildConfig
import com.elkhami.foodcategories.data.model.FoodCategories
import com.elkhami.foodcategories.data.model.Product
import com.elkhami.foodcategories.data.other.Status
import com.elkhami.foodcategories.data.repository.FoodCategoryRepository
import com.elkhami.foodcategories.view.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesListViewModel @Inject constructor(
    private val repository: FoodCategoryRepository,
) : ViewModel() {

    private val currentState = UiState<List<Product>>()

    private val _uiStateFlow = MutableStateFlow(currentState)

    var uiStateFlow = _uiStateFlow.asStateFlow()

    init {
        getFoodCategories()
    }

    fun getFoodCategories() {
        _uiStateFlow.value =
            UiState(
                isLoading = true
            )

        viewModelScope.launch {
            val response = repository.getFoodCategories()
            when (response.status) {
                Status.SUCCESS -> {
                    response.data?.let { foodCategories ->

                        val productList = flattenFoodCategoriesToProductList(foodCategories)

                        mapImageUrlString(productList)

                        _uiStateFlow.value =
                            UiState(
                                data = productList,
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
            }
        }
    }

    fun flattenFoodCategoriesToProductList(foodCategories: FoodCategories): List<Product> {
        return foodCategories.flatMap { foodCategory ->
            mutableListOf(Product(name = foodCategory.name)).also {
                it.addAll(foodCategory.products)
            }
        }
    }

    fun mapImageUrlString(productList: List<Product>) {
        productList.map { product ->
            product.url = product.url?.let {
                BuildConfig.BASE_URL
                    .replaceAfter("com", it, "//")
            }
        }
    }

}