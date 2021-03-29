package com.example.coroutineretrofit.Network

import com.example.coroutineretrofit.Model.PostData
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    suspend fun getPost():List<PostData>
}