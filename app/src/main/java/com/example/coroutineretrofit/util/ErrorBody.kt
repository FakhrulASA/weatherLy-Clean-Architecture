package com.example.coroutineretrofit.util

data class ErrorBody(
    var isError: Boolean = false,
    var message: String = ""
)