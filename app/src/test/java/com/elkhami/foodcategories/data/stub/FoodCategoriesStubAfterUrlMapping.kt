package com.elkhami.foodcategories.data.stub

import com.elkhami.foodcategories.data.model.FoodCategories
import com.elkhami.foodcategories.data.model.FoodCategory
import com.elkhami.foodcategories.data.model.Product

class FoodCategoriesStubAfterUrlMapping {

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

    val outProductsListAfterMapping = listOf(
        outProduct1,
        outProduct2
    )

    val outFoodCategoryAfterMapping =
        FoodCategory("desc", "1", "Food", outProductsListAfterMapping)

    val outFoodCategoriesAfterMapping = FoodCategories().apply {
        add(outFoodCategoryAfterMapping)
    }
}