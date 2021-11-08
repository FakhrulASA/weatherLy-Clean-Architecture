package com.example.coroutineretrofit.interactor

import com.example.coroutineretrofit.model.WeatherData
import com.example.coroutineretrofit.model.WeatherRequestModel
import com.example.coroutineretrofit.repository.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class WeatherUsecase {
    var weatherRepository: WeatherRepository = WeatherRepository()
    private val job = CoroutineScope(Dispatchers.IO)
    fun invoke(
        weatherRequestModel: WeatherRequestModel,
        isSuccess: (WeatherData) -> Unit,
        isFailed: (String) -> Unit
    ) {
        val weather = weatherRepository.getPost(
            weatherRequestModel.type,
            weatherRequestModel.host,
            weatherRequestModel.key,
            weatherRequestModel.lat,
            weatherRequestModel.lon
        )
        CoroutineScope(Dispatchers.IO).launch {
            weather.execute().apply {
                when (this.isSuccessful) {
                    true -> isSuccess.invoke(this.body()!!)
                    false -> isFailed.invoke(this.message())
                }
            }
        }
    }
    fun cancel(onCancelled:()->Unit){
        job.cancel("Job Cancelled")
        onCancelled.invoke()
    }
}
