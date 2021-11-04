package com.example.coroutineretrofit.interactor

import com.example.coroutineretrofit.model.PostData
import com.example.coroutineretrofit.repository.PostRepo

class LoginUserUseCase {
    var postRepo: PostRepo = PostRepo()

    suspend operator fun invoke(lat:Double,lon:Double): PostData {
        val response = postRepo.getAllPost(lat,lon)
        return response
    }
}
