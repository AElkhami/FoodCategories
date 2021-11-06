package com.elkhami.foodcategories.data.model

data class FoodCategory(
    val description: String,
    val id: String,
    val name: String,
    val products: List<Product>
)