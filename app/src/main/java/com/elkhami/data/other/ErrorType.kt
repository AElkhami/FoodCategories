package com.elkhami.data.other

/**
 * Created by A.Elkhami on 06,November,2021
 */
sealed class ErrorType{
    object UnknownError: ErrorType()
    object NetworkError: ErrorType()
}
