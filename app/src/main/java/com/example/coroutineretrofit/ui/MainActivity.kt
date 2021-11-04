package com.example.coroutineretrofit.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutineretrofit.adapter.PostAdapter
import com.example.coroutineretrofit.R
import com.example.coroutineretrofit.repository.PostRepo
import com.example.coroutineretrofit.util.Util
import com.example.coroutineretrofit.util.Util.isInternetAvailable
import com.example.coroutineretrofit.util.Util.showToast

class MainActivity : AppCompatActivity() {
    private lateinit var postRepo: PostRepo
    private lateinit var postAdapter: PostAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        val postViewModel: PostViewModel by viewModels()
        recyclerView = findViewById(R.id.recycleLayout)
        if(isInternetAvailable(this)){
            postRepo = PostRepo()
            postViewModel.myResponse.observe(this, Observer {
                Toast.makeText(this,it,Toast.LENGTH_LONG).show()
            })
        }else{
            showToast(this,"Internet Not Available")
        }



    }



    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recycleLayout)
        postAdapter = PostAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter=postAdapter

        }
    }
}