package com.example.coroutineretrofit.repository

import com.example.coroutineretrofit.model.WeatherData
import com.example.coroutineretrofit.model.WeatherDataHourly
import com.example.coroutineretrofit.network.ApiInterface
import com.example.coroutineretrofit.network.RetroBuilder
import retrofit2.Call

class WeatherRepository:ApiInterface {

    override fun getPost(
        contentType: String,
        apiHost: String,
        apiKey: String,
        lat: Double,
        lon: Double
    ): Call<WeatherData>  = RetroBuilder.api.getPost(contentType,apiHost,apiKey,lat,lon)
    override fun getHourly(
        contentType: String,
        apiHost: String,
        apiKey: String,
        lat: Double,
        lon: Double
    ): Call<WeatherDataHourly> = RetroBuilder.api.getHourly(contentType,apiHost,apiKey,lat,lon)

}