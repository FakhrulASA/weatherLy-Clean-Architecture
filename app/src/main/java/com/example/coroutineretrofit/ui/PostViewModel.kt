package com.example.coroutineretrofit.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coroutineretrofit.interactor.HourlyDataUseCase
import com.example.coroutineretrofit.interactor.WeatherUsecase
import com.example.coroutineretrofit.model.WeatherData
import com.example.coroutineretrofit.model.WeatherDataHourly
import com.example.coroutineretrofit.model.WeatherRequestModel
import com.example.coroutineretrofit.util.ErrorBody
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    var weatherUsecase: WeatherUsecase = WeatherUsecase()
    var hourlyDataUseCase: HourlyDataUseCase = HourlyDataUseCase()
    var myResponse: MutableLiveData<WeatherData> = MutableLiveData()
    var myResponseHourly: MutableLiveData<WeatherDataHourly> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val error: MutableLiveData<ErrorBody> = MutableLiveData()


    fun getWeather(weatherRequestModel: WeatherRequestModel) {
        isLoading.postValue(true)
        CoroutineScope(Dispatchers.IO).launch {
            weatherUsecase.invoke(weatherRequestModel, {
                error.postValue(ErrorBody(false, "success"))
                myResponse.postValue(it)
                isLoading.postValue(false)
            }, {
                error.postValue(ErrorBody(true, it))
                isLoading.postValue(false)
            })
        }

    }
    fun getHourly(weatherRequestModel: WeatherRequestModel) {
        isLoading.postValue(true)
        CoroutineScope(Dispatchers.IO).launch {
            hourlyDataUseCase.invoke(weatherRequestModel, {
                error.postValue(ErrorBody(false, "success"))
                myResponseHourly.postValue(it)
                isLoading.postValue(false)
            }, {
                error.postValue(ErrorBody(true, it))
                Log.d("errorCode",it)
                isLoading.postValue(false)
            })
        }

    }

}