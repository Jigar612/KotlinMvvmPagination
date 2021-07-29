package com.example.myapplicationwithpaging3.adapter.pagingnation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapplicationwithpaging3.databinding.ItemLayoutBinding
import com.example.myapplicationwithpaging3.model.UserDataModel
import javax.inject.Inject

class PageListAdapter @Inject constructor() :
    PagingDataAdapter<UserDataModel, PageListAdapter.MyViewHolder>(Diff()) {


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.binds(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    class MyViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun binds(data: UserDataModel) {
            binding.apply {
                tvFirstName.text = data.first_name
                tvLastName.text = data.last_name
                ivPhoto.load(
                    data.avatar
                )


            }
        }
    }

    class Diff : DiffUtil.ItemCallback<UserDataModel>() {
        override fun areItemsTheSame(oldItem: UserDataModel, newItem: UserDataModel): Boolean =
            oldItem.first_name == newItem.first_name

        override fun areContentsTheSame(oldItem: UserDataModel, newItem: UserDataModel): Boolean =
            oldItem == newItem
    }
}
