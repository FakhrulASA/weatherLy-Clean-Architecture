package com.example.coroutineretrofit.model

import com.example.coroutineretrofit.util.AuthParams

class WeatherRequestModel {
    var type: String = AuthParams.CONTENT_TYPE
    var host: String = AuthParams.API_HOST
    var key: String = AuthParams.API_KEY
    var lat: Double = 35.0
    var lon: Double = -75.5
}