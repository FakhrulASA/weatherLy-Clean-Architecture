package com.example.coroutineretrofit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutineretrofit.model.WeatherDataHourly
import com.example.coroutineretrofit.R
import com.example.coroutineretrofit.databinding.ItemBinding
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class PostAdapter(private val context: Context, private var weatherList: List<WeatherDataHourly.Companion.Datum>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    class PostViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        //

        fun bindView(list : List<WeatherDataHourly.Companion.Datum>, position : Int){


            binding.description.text="Temperature: "+list.get(position).temp.toString()+" C"+"     "+"Wind Speed: "+list.get(position).windSpd+"/kmh"+"\n"+"Wind Direction: "+list.get(position).windCdirFull
            val dateString = list.get(position).timestampLocal
            val separated = dateString?.split("T")?.toTypedArray()!!
            separated[0] // this will contain "2016-10-02"
            separated[1]
            binding.title2.text="Time: "+ separated[1]+", "+separated[0]
        }

    }

    override fun getItemCount(): Int =weatherList.size

    override fun onBindViewHolder(holder: PostAdapter.PostViewHolder, position: Int) {
        holder.bindView(weatherList,position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder =
        PostViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    fun setData(weatherList: List<WeatherDataHourly.Companion.Datum>)
    {
        this.weatherList=weatherList
        notifyDataSetChanged()
    }

}