package com.example.coroutineretrofit.Network

import com.example.coroutineretrofit.Model.PostData
import com.example.coroutineretrofit.Repository.PostRepo

class LoginUserUseCase {
    var postRepo: PostRepo = PostRepo()

    suspend operator fun invoke(): List<PostData> {
        val response = postRepo.getAllPost()
        return response
    }
}
