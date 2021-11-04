package com.example.coroutineretrofit.interactor

import com.example.coroutineretrofit.repository.PostRepo

class LoginUserUseCase {
    var postRepo: PostRepo = PostRepo()

    suspend operator fun invoke(): String {
        val response = postRepo.getAllPost()
        return response.bpi?.usd?.rate!!
    }
}
