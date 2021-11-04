package com.example.coroutineretrofit.interactor

import com.example.coroutineretrofit.model.PostData
import com.example.coroutineretrofit.repository.PostRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginUserUseCase {
    var postRepo: PostRepo = PostRepo()

    operator fun invoke(lat:Double,lon:Double,isSuccess:(PostData)->Unit,isFailed:(String)->Unit) {
        val weather = postRepo.getAllPost(lat,lon)
        CoroutineScope(Dispatchers.IO).launch {
            weather.execute().apply {
                when (this.isSuccessful){
                    true->isSuccess.invoke(this.body()!!)
                    false->isFailed.invoke(this.message())
                }
            }
        }
    }
}
