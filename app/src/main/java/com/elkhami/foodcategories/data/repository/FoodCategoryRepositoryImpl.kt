package com.elkhami.foodcategories.data.repository

import android.util.Log
import com.elkhami.foodcategories.data.model.FoodCategories
import com.elkhami.foodcategories.data.other.ErrorType
import com.elkhami.foodcategories.data.other.Resource
import com.elkhami.foodcategories.data.remote.FoodCategoriesApi
import com.elkhami.foodcategories.utils.Constants.TAG
import javax.inject.Inject

/**
 * Created by A.Elkhami on 06,November,2021
 */
class FoodCategoryRepositoryImpl @Inject constructor(
    private val api: FoodCategoriesApi
) :
    FoodCategoryRepository {

    override suspend fun getFoodCategories(): Resource<FoodCategories> {

        return try {
            val response = api.getFoodCategories()

            if (response.isSuccessful) {
                response.body()?.let { foodCategories ->
                    Resource.Success(foodCategories)
                } ?: run {
                    Resource.Error(message = response.message(), errorType = ErrorType.ResponseError)
                }
            } else {
                Resource.Error(errorType = ErrorType.UnknownError)
            }
        }catch (e: Exception){
            Log.e(TAG, "EXCEPTION:", e)
            Resource.Error(errorType = ErrorType.NetworkError)
        }
    }
}