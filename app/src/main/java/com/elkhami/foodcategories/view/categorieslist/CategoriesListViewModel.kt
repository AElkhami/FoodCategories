package com.elkhami.foodcategories.view.categorieslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elkhami.foodcategories.BuildConfig
import com.elkhami.foodcategories.data.model.FoodCategories
import com.elkhami.foodcategories.data.model.Product
import com.elkhami.foodcategories.data.other.Status
import com.elkhami.foodcategories.data.repository.FoodCategoryRepository
import com.elkhami.foodcategories.view.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesListViewModel @Inject constructor(
    private val repository: FoodCategoryRepository,
) : ViewModel() {

    private var isDataReturned = false

    private val currentState = UiState<List<Product>>()

    private val _uiStateFlow = MutableStateFlow(currentState)

    var uiStateFlow = _uiStateFlow.asStateFlow()

    fun updateUiWithData() {
        if(isDataReturned){
            return
        }

        _uiStateFlow.value = UiState(isLoading = true)

        viewModelScope.launch {
            val foodCategoriesList = getFoodCategories()

            foodCategoriesList?.let {
                val productList = flattenFoodCategoriesToProductList(it)

                val mappedProductList = mapImageUrlString(productList)

                _uiStateFlow.value = UiState(data = mappedProductList, isLoading = false)
            }
        }
    }

    suspend fun getFoodCategories(): FoodCategories? {

        val response = repository.getFoodCategories()
        return when (response.status) {
            Status.SUCCESS -> {
                isDataReturned = true
                response.data
            }
            Status.FAILED -> {
                _uiStateFlow.value = UiState(
                    errorType = response.errorType,
                    message = response.message,
                    isLoading = false
                )
                null
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

    fun mapImageUrlString(productList: List<Product>): List<Product> {
        productList.map { product ->
            product.url = product.url?.let {
                BuildConfig.BASE_URL
                    .replaceAfter("com", it, "//")
            }
        }
        return productList
    }

}