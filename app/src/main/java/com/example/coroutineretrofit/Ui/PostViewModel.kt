package com.example.coroutineretrofit.Ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutineretrofit.Model.PostData
import com.example.coroutineretrofit.Network.LoginUserUseCase
import com.example.coroutineretrofit.Repository.PostRepo
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    var postRepo: PostRepo = PostRepo()
    var loginUserUseCase: LoginUserUseCase = LoginUserUseCase()
    var myResponse: MutableLiveData<List<PostData>> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    init {
        viewModelScope.launch {
            myResponse.postValue(loginUserUseCase.invoke())
        }
    }

}