package com.example.coroutineretrofit.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutineretrofit.Model.PostData
import com.example.coroutineretrofit.R

class PostAdapter(private val context: Context, private var postList: ArrayList<PostData>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //
        fun bindView(list : ArrayList<PostData>, position : Int){
            itemView.findViewById<AppCompatTextView>(R.id.title2).text=list.get(position).title
            itemView.findViewById<AppCompatTextView>(R.id.description).text=list.get(position).id.toString()
        }


        val title: AppCompatTextView = itemView.findViewById(R.id.title2)
        val description: AppCompatTextView=itemView.findViewById(R.id.description)
    }

    override fun getItemCount(): Int =postList.size

    override fun onBindViewHolder(holder: PostAdapter.PostViewHolder, position: Int) {
        holder.bindView(postList,position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder =
        PostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))

    fun setData(postList: ArrayList<PostData>)
    {
        this.postList=postList
        notifyDataSetChanged()
    }
}