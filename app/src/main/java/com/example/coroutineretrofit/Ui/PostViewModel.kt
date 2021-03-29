package com.example.coroutineretrofit.Ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutineretrofit.Model.PostData
import com.example.coroutineretrofit.Repository.PostRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class PostViewModel(private val postRepo: PostRepo): ViewModel() {
    val myResponse:MutableLiveData<List<PostData>> = MutableLiveData()
    val isLoading:MutableLiveData<Boolean> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch{
            try {
                val response=postRepo.getAllPost()
                myResponse.value=response

            }catch (e:Exception){

            }
        }
    }
}