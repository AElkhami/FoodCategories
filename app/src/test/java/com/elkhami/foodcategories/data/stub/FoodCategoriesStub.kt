package com.elkhami.foodcategories.data.stub

import com.elkhami.foodcategories.data.model.FoodCategories
import com.elkhami.foodcategories.data.model.FoodCategory
import com.elkhami.foodcategories.data.model.Product
import com.elkhami.foodcategories.data.model.SalePrice

/**
 * Created by A.Elkhami on 07,November,2021
 */
object FoodCategoriesStub {

    private val salePrice = SalePrice("10", "EGP")
    private val product1 = Product(
        categoryId = null,
        description = null,
        id = null,
        name = "Food",
        salePrice = null,
        url = null
    )
    private val product2 = Product("1", "dec", "1", "Apple", salePrice, "")
    val productsList = listOf(product2)
    val foodCategory = FoodCategory("desc", "1", "Food", productsList)

    val foodCategories = FoodCategories().apply {
        add(foodCategory)
    }

    val mockedProductsList = listOf(product1, product2)
}