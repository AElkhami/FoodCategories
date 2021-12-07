package com.elkhami.foodcategories.data.stub

import com.elkhami.foodcategories.data.model.FoodCategories
import com.elkhami.foodcategories.data.model.FoodCategory
import com.elkhami.foodcategories.data.model.Product
import com.elkhami.foodcategories.data.model.SalePrice

class OutputFoodCategoriesStub {

    val outSalePrice = SalePrice("10", "EGP")

    val outProduct1 = Product(
        categoryId = "2",
        description = "desc",
        id = "1",
        name = "Orange",
        salePrice = outSalePrice,
        url = "/image.jpg"
    )
    val outProduct2 = Product(
        "1",
        "dec",
        "2",
        "Apple",
        outSalePrice,
        "/image2.jpg"
    )

    val outProductsList = listOf(outProduct1, outProduct2)

    val outFoodCategory = FoodCategory("desc", "1", "Food", outProductsList)

    val outFoodCategories = FoodCategories().apply {
        add(outFoodCategory)
    }

}