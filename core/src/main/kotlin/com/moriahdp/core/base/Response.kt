package com.moriahdp.core.base

data class Response<T>(
    val data: T,
    val status: Boolean,
    val message: String
)