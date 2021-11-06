package com.elkhami.foodcategories.data.remote

import com.elkhami.foodcategories.data.model.FoodCategories
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by A.Elkhami on 06,November,2021
 */
interface FoodCategoriesApi {
    @GET(".")
    suspend fun getFoodCategories(): Response<FoodCategories>
}