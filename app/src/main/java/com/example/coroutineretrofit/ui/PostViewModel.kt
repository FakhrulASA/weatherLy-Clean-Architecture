package com.example.coroutineretrofit.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutineretrofit.interactor.LoginUserUseCase
import com.example.coroutineretrofit.model.PostData
import com.example.coroutineretrofit.repository.PostRepo
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    var postRepo: PostRepo = PostRepo()
    var loginUserUseCase: LoginUserUseCase = LoginUserUseCase()
    var myResponse: MutableLiveData<PostData> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    var error : Boolean=false

    fun getWeather(lat:Double,lon:Double){
        viewModelScope.launch {
            var data=loginUserUseCase.invoke(lat,lon)
            if(data.equals("failed"))
            {
                error=true
            }
            else{
                myResponse.postValue(loginUserUseCase.invoke(lat,lon) as PostData)
            }

        }

    }


}