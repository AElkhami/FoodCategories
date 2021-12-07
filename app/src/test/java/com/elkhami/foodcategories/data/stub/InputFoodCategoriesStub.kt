package com.elkhami.foodcategories.data.stub

import com.elkhami.foodcategories.data.model.FoodCategories
import com.elkhami.foodcategories.data.model.FoodCategory
import com.elkhami.foodcategories.data.model.Product
import com.elkhami.foodcategories.data.model.SalePrice

/**
 * Created by A.Elkhami on 07,November,2021
 */
class InputFoodCategoriesStub {

    val inSalePrice = SalePrice("10", "EGP")

    val inProduct1 = Product(
        categoryId = "2",
        description = "desc",
        id = "1",
        name = "Orange",
        salePrice = inSalePrice,
        url = "/image.jpg"
    )
    val inProduct2 = Product(
        "1",
        "dec",
        "2",
        "Apple",
        inSalePrice,
        "/image2.jpg"
    )

    val inProductsList = listOf(inProduct1, inProduct2)

    val inFoodCategory = FoodCategory("desc", "1", "Food", inProductsList)

    val inFoodCategories = FoodCategories().apply {
        add(inFoodCategory)
    }
}