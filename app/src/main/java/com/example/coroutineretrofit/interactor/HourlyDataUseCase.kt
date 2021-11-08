package com.example.coroutineretrofit.interactor

import com.example.coroutineretrofit.model.WeatherDataHourly
import com.example.coroutineretrofit.model.WeatherRequestModel
import com.example.coroutineretrofit.repository.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class HourlyDataUseCase {
    var weatherRepository: WeatherRepository = WeatherRepository()
    private val job = CoroutineScope(Dispatchers.IO)

    fun invoke(weatherRequestModel: WeatherRequestModel, isSuccess:(WeatherDataHourly)->Unit, isFailed:(String)->Unit) {
        val weather = weatherRepository.getHourly(
            weatherRequestModel.type,
            weatherRequestModel.host,
            weatherRequestModel.key,
            weatherRequestModel.lat,
            weatherRequestModel.lon
        )
        job.launch {
            weather.execute().apply {
                when (this.isSuccessful){
                    true->isSuccess.invoke(this.body()!!)
                    false->isFailed.invoke(this.message())
                }
            }
        }
    }
    fun cancel(onCancelled:()->Unit){
        job.cancel("Job Cancelled")
        onCancelled.invoke()
    }
}