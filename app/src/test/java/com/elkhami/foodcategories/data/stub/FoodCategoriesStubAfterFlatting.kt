package com.elkhami.foodcategories.data.stub

import com.elkhami.foodcategories.data.model.FoodCategories
import com.elkhami.foodcategories.data.model.FoodCategory
import com.elkhami.foodcategories.data.model.Product

class FoodCategoriesStubAfterFlatting {

    val outProduct0 = Product(
        categoryId = null,
        description = null,
        id = null,
        name = "Food",
        salePrice = null,
        url = null
    )

    val outProduct1 = Product(
        categoryId = "2",
        description = "desc",
        id = "1",
        name = "Orange",
        salePrice = OutputFoodCategoriesStub().outSalePrice,
        url = "/image.jpg"
    )
    val outProduct2 = Product(
        "1",
        "dec",
        "2",
        "Apple",
        OutputFoodCategoriesStub().outSalePrice,
        "/image2.jpg"
    )

    val outProductsListAfterFlatting = listOf(
        outProduct0,
        outProduct1,
        outProduct2
    )

    val outFoodCategoryAfterFlatting =
        FoodCategory("desc", "1", "Food", outProductsListAfterFlatting)

    val outFoodCategoriesAfterFlatting = FoodCategories().apply {
        add(outFoodCategoryAfterFlatting)
    }
}