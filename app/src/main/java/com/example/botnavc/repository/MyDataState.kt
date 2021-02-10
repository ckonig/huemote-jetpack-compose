package com.example.botnavc.repository

import java.lang.Exception

sealed class MyDataState<out R> {
    data class Success<out T>(val data: T) : MyDataState<T>()
    data class Error(val exception: Exception): MyDataState<Nothing>()
    object Loading : MyDataState<Nothing>()
}