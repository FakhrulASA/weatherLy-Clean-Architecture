package com.example.coroutineretrofit.repository

import com.example.coroutineretrofit.model.WeatherData
import com.example.coroutineretrofit.model.WeatherDataHourly
import com.example.coroutineretrofit.network.ApiInterface
import com.example.coroutineretrofit.network.RetroBuilder
import retrofit2.Call

class WeatherRepository:ApiInterface {
    override fun getPost(lat: Double, lon: Double): Call<WeatherData> {
        return  RetroBuilder.api.getPost(lat,lon)
    }

    override fun getHourly(lat: Double, lon: Double): Call<WeatherDataHourly> {
        return  RetroBuilder.api.getHourly(lat,lon)
    }
}