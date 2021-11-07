package com.elkhami.foodcategories.data.repository

import com.elkhami.foodcategories.data.model.FoodCategories
import com.elkhami.foodcategories.data.other.ErrorType
import com.elkhami.foodcategories.data.other.Resource
import com.elkhami.foodcategories.data.stub.FoodCategoriesStub


/**
 * Created by A.Elkhami on 07,November,2021
 */
class TestFoodCategoryRepository : FoodCategoryRepository{

    private var shouldReturnError = false

    fun setReturnError(value: Boolean){
        shouldReturnError =  value
    }

    override suspend fun getFoodCategories(): Resource<FoodCategories> {
        return if(shouldReturnError){
            Resource.Error(message = "error", errorType = ErrorType.UnknownError)
        }else{
            Resource.Success(FoodCategoriesStub.foodCategories)
        }
    }


}