package com.example.coroutineretrofit.repository

import com.example.coroutineretrofit.model.WeatherData
import com.example.coroutineretrofit.network.RetroBuilder
import retrofit2.Call

class WeatherRepository {
    fun getAllPost(lat:Double,lon:Double): Call<WeatherData> {
       return  RetroBuilder.api.getPost(lat,lon)
    }
}