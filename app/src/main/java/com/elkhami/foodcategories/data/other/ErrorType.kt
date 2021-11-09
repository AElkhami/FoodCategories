package com.elkhami.foodcategories.data.other

/**
 * Created by A.Elkhami on 06,November,2021
 */
sealed class ErrorType{
    object ResponseError: ErrorType()
    object UnknownError: ErrorType()
    object NetworkError: ErrorType()
}
