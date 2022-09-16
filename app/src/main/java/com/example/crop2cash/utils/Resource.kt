package com.example.crop2cash.utils

sealed class Resource<T>(
    val data : T? = null,
    val message : Throwable? =  null
) {
    //when success, do this
    class Success<T>(data: T) : Resource<T>(data,null)
    //when error, get the error message
    class Error<T>(message: Throwable) : Resource<T>(null, message)

    class Loading<T> : Resource<T>()
}