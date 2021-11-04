package com.example.coroutineretrofit.network

import com.example.coroutineretrofit.model.PostData
import retrofit2.http.GET

interface ApiInterface {
    @GET("currentprice.json")
    suspend fun getPost():PostData
}