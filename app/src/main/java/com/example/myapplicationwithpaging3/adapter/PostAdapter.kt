package com.example.myapplicationwithpaging3.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationwithpaging3.R
import com.example.myapplicationwithpaging3.model.UserDataModel

class PostAdapter(private val context: Context, private var postList: ArrayList<UserDataModel>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder =
        PostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )

    override fun getItemCount(): Int = postList.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        holder.firstName.text = post.first_name
        holder.lastName.text = post.last_name
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstName: TextView = itemView.findViewById(R.id.tvFirstName)
        val lastName: TextView = itemView.findViewById(R.id.tvLastName)
    }

    fun setPost(postList: ArrayList<UserDataModel>) {
        this.postList = postList
        notifyDataSetChanged()
    }
}