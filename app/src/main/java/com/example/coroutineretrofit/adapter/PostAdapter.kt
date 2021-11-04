package com.example.coroutineretrofit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutineretrofit.model.WeatherData
import com.example.coroutineretrofit.R

class PostAdapter(private val context: Context, private var weatherList: ArrayList<WeatherData>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //
        fun bindView(list : ArrayList<WeatherData>, position : Int){
//            itemView.findViewById<AppCompatTextView>(R.id.title2).text=list.get(position).title
//            itemView.findViewById<AppCompatTextView>(R.id.description).text=list.get(position).id.toString()
        }


        val title: AppCompatTextView = itemView.findViewById(R.id.title2)
        val description: AppCompatTextView=itemView.findViewById(R.id.description)
    }

    override fun getItemCount(): Int =weatherList.size

    override fun onBindViewHolder(holder: PostAdapter.PostViewHolder, position: Int) {
        holder.bindView(weatherList,position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder =
        PostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))

    fun setData(weatherList: ArrayList<WeatherData>)
    {
        this.weatherList=weatherList
        notifyDataSetChanged()
    }
}