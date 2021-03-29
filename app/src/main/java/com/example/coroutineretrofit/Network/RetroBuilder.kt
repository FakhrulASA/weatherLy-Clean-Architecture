package com.example.coroutineretrofit.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetroBuilder {
    companion object{
        private val retrofit:Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BaseUrl.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api:ApiInterface by lazy {
            retrofit.create(ApiInterface::class.java)
        }
    }
}