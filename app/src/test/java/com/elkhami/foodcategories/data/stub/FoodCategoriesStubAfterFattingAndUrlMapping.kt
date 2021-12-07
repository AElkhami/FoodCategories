package com.elkhami.foodcategories.data.stub

import com.elkhami.foodcategories.data.model.FoodCategories
import com.elkhami.foodcategories.data.model.FoodCategory
import com.elkhami.foodcategories.data.model.Product

class FoodCategoriesStubAfterFattingAndUrlMapping {

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
        url = "http://mobcategories.s3-website-eu-west-1.amazonaws.com/image.jpg"
    )
    val outProduct2 = Product(
        "1",
        "dec",
        "2",
        "Apple",
        OutputFoodCategoriesStub().outSalePrice,
        "http://mobcategories.s3-website-eu-west-1.amazonaws.com/image2.jpg"
    )

    val outProductsListAfterFattingAndUrlMapping = listOf(
        outProduct0,
        outProduct1,
        outProduct2
    )

    val outFoodCategoryAfterFattingAndUrlMapping =
        FoodCategory("desc", "1", "Food", outProductsListAfterFattingAndUrlMapping)

    val outFoodCategoriesAfterFattingAndUrlMapping = FoodCategories().apply {
        add(outFoodCategoryAfterFattingAndUrlMapping)
    }
}