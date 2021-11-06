package com.example.coroutineretrofit.network

import com.example.coroutineretrofit.model.WeatherData
import com.example.coroutineretrofit.model.WeatherDataHourly
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiInterface {
    @GET("current")
    fun getPost(
        @Header("Content-Type") contentType: String,
        @Header("x-rapidapi-host") apiHost: String,
        @Header("x-rapidapi-key") apiKey: String,
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): Call<WeatherData>

    @GET("/forecast/3hourly")
    fun getHourly(
        @Header("Content-Type") contentType: String,
        @Header("x-rapidapi-host") apiHost: String,
        @Header("x-rapidapi-key") apiKey: String,
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): Call<WeatherDataHourly>

}