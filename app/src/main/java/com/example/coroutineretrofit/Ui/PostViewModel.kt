package com.example.coroutineretrofit.Ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutineretrofit.Model.PostData
import com.example.coroutineretrofit.Repository.PostRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class PostViewModel:ViewModel() {
    var postRepo:PostRepo=PostRepo()
    val myResponse:MutableLiveData<List<PostData>> = MutableLiveData()
    val isLoading:MutableLiveData<Boolean> = MutableLiveData()

    init {
        viewModelScope.launch{
            try {
                val response=postRepo.getAllPost()
                myResponse.value=response

            }catch (e:Exception){

            }
        }
    }


}