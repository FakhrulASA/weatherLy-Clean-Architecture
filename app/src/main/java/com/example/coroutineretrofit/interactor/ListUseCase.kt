package com.example.coroutineretrofit.interactor

import com.example.coroutineretrofit.model.PostData
import com.example.coroutineretrofit.repository.PostRepo

class LoginUserUseCase {
    var postRepo: PostRepo = PostRepo()

    suspend operator fun invoke(lat:Double,lon:Double): Any {
        val response = postRepo.getAllPost(lat,lon)
        val data=response.execute()
        return if(data.isSuccessful){
            data.body()!!
        } else {
            "failed"
        }
    }
}
