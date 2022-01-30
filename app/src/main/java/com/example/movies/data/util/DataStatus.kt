package com.example.movies.data.util

sealed class DataStatus<T>(val data: T? = null, val message: String? = null) {
    class Loading<T> : DataStatus<T>()
    class Success<T>(data: T) : DataStatus<T>(data = data)
    class Error<T>(message: String) : DataStatus<T>(message = message)
}