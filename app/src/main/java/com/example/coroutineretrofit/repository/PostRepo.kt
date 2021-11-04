package com.example.coroutineretrofit.repository

import com.example.coroutineretrofit.model.PostData
import com.example.coroutineretrofit.network.RetroBuilder

class PostRepo {
    suspend fun getAllPost():PostData {

       return RetroBuilder.api.getPost()
    }
}