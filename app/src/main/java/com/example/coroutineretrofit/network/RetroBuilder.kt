package com.example.coroutineretrofit.network

import com.example.coroutineretrofit.util.BaseUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroBuilder {
    companion object {
        private val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BaseUrl.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api: ApiInterface by lazy {
            retrofit.create(ApiInterface::class.java)
        }

    }
}