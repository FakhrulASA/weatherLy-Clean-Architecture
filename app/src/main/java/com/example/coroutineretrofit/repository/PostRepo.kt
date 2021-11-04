package com.example.coroutineretrofit.repository

import com.example.coroutineretrofit.model.PostData
import com.example.coroutineretrofit.network.RetroBuilder
import retrofit2.Call

class PostRepo {
    suspend fun getAllPost(lat:Double,lon:Double): Call<PostData> {
       return  RetroBuilder.api.getPost(lat,lon)
    }
}