package com.peeyoosh.core.common

sealed class NetworkResult<T>{
    data class Loading<T>(val isLoading: Boolean) : NetworkResult<T>()
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class Failure<T>(val errorMsg: String) : NetworkResult<T>()
}
