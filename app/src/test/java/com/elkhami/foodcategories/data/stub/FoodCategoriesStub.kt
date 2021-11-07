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
    private val product = Product("1", "dec","1", "Apple", salePrice, "")
    private val productsList = listOf(product)
    private val foodCategory = FoodCategory("desc", "1", "Food", productsList)
    val foodCategories = listOf(foodCategory) as FoodCategories

}