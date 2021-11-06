package com.elkhami.data.repository

import com.elkhami.data.model.FoodCategories
import com.elkhami.data.other.Resource

/**
 * Created by A.Elkhami on 06,November,2021
 */
interface FoodCategoryRepository {

    suspend fun getFoodCategories(): Resource<FoodCategories>
}