package com.example.coroutineretrofit.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coroutineretrofit.interactor.WeatherUsecase
import com.example.coroutineretrofit.model.WeatherData
import com.example.coroutineretrofit.model.WeatherRequestModel
import com.example.coroutineretrofit.repository.WeatherRepository
import com.example.coroutineretrofit.util.ErrorBody
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    var weatherRepository: WeatherRepository = WeatherRepository()
    var weatherUsecase: WeatherUsecase = WeatherUsecase()
    var myResponse: MutableLiveData<WeatherData> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val error:MutableLiveData<ErrorBody> = MutableLiveData()


    fun getWeather(weatherRequestModel: WeatherRequestModel){
        CoroutineScope(Dispatchers.IO).launch {
            weatherUsecase.invoke(weatherRequestModel,{
                error.postValue(ErrorBody(false,"success"))
                myResponse.postValue(it)
            },{
                error.postValue(ErrorBody(true,it))
            })
        }

    }


}