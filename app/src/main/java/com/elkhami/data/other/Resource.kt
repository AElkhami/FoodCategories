package com.elkhami.data.other

/**
 * Created by A.Elkhami on 06,November,2021
 */
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
    val errorType: ErrorType? = null,
    val status: Status
) {
    class Success<T>(data: T) : Resource<T>(data = data, status = Status.SUCCESS)
    class Error<T>(data: T? = null, message: String? = null, errorType: ErrorType) : Resource<T>(
        data = data, message = message, errorType = errorType, status = Status.FAILED
    )

    class Loading<T>() : Resource<T>(status = Status.LOADING)
}

enum class Status {
    SUCCESS,
    FAILED,
    LOADING
}