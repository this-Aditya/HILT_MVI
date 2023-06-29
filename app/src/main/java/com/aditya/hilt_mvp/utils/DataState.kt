package com.aditya.hilt_mvp.utils

import java.lang.Exception

sealed class DataState<out R> {
    data class Success<out T>(val data: T): DataState<T>()
    data class Error(val ex: Exception): DataState<Nothing>()
    object Loading: DataState<Nothing>()
}