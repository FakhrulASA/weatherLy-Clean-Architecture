package com.example.coroutineretrofit.network

import com.example.coroutineretrofit.model.WeatherData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {
    @GET("current")
    @Headers("Content-Type:application/x-www-form-urlencoded","x-rapidapi-host:weatherbit-v1-mashape.p.rapidapi.com","x-rapidapi-key:9b331297cfmsh8758e425c669262p177a17jsn246545f467d2")
    fun getPost(
        @Query("lat") lat:Double,
        @Query("lon") lon:Double
    ): Call<WeatherData>
}