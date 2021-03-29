package com.example.coroutineretrofit.Repository

import com.example.coroutineretrofit.Model.PostData
import com.example.coroutineretrofit.Network.RetroBuilder

class PostRepo {
    suspend fun getAllPost():List<PostData> = RetroBuilder.api.getPost()
}