package com.example.coroutineretrofit.Ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coroutineretrofit.Repository.PostRepo

class PostViewModelFactory(private val postRepo:PostRepo):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        PostViewModel(postRepo) as T
}