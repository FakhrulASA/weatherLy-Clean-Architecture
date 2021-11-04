package com.example.coroutineretrofit.repository

import com.example.coroutineretrofit.model.PostData
import com.example.coroutineretrofit.network.RetroBuilder

class PostRepo {
    suspend fun getAllPost(lat:Double,lon:Double):PostData {
       return RetroBuilder.api.getPost(lat,lon)
    }
}