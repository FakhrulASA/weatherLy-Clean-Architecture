package com.example.coroutineretrofit.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutineretrofit.interactor.LoginUserUseCase
import com.example.coroutineretrofit.repository.PostRepo
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    var postRepo: PostRepo = PostRepo()
    var loginUserUseCase: LoginUserUseCase = LoginUserUseCase()
    var myResponse: MutableLiveData<String> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    init {
        viewModelScope.launch {
            myResponse.postValue(loginUserUseCase.invoke())
        }
    }

}