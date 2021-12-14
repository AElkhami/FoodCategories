package com.elkhami.foodcategories.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    var categoryId: String? = null,
    var description: String? = null,
    var id: String? = null,
    var name: String? = null,
    var salePrice: SalePrice? = null,
    var url: String? = null
): Parcelable