package com.elkhami.foodcategories.data.model

data class Product(
    var categoryId: String? = null,
    var description: String? = null,
    var id: String? = null,
    var name: String? = null,
    var salePrice: SalePrice? = null,
    var url: String? = null
)