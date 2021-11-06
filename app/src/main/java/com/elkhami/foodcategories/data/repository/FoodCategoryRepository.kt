package com.elkhami.foodcategories.data.repository

import com.elkhami.foodcategories.data.model.FoodCategories
import com.elkhami.foodcategories.data.other.Resource

/**
 * Created by A.Elkhami on 06,November,2021
 */
interface FoodCategoryRepository {

    suspend fun getFoodCategories(): Resource<FoodCategories>
}