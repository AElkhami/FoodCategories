package com.elkhami.data.repository

import android.util.Log
import com.elkhami.data.model.FoodCategories
import com.elkhami.data.other.ErrorType
import com.elkhami.data.other.Resource
import com.elkhami.data.remote.FoodCategoriesApi
import java.lang.Exception
import javax.inject.Inject

/**
 * Created by A.Elkhami on 06,November,2021
 */
class FoodCategoryRepositoryImpl @Inject constructor(
    private val api: FoodCategoriesApi
) :
    FoodCategoryRepository {

    override suspend fun getFoodCategories(): Resource<FoodCategories> {
        val response = api.getFoodCategories()

        return try {
            if (response.isSuccessful) {
                response.body()?.let { foodCategories ->
                    Resource.Success(foodCategories)
                } ?: run {
                    Resource.Error(message = response.message(), errorType = ErrorType.UnknownError)
                }
            } else {
                Resource.Error(message = response.message(), errorType = ErrorType.UnknownError)
            }
        }catch (e: Exception){
            Log.e("EXCEPTION", "EXCEPTION:", e)
            Resource.Error(errorType = ErrorType.NetworkError)
        }

    }
}