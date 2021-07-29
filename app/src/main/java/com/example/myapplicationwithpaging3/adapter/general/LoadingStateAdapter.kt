package com.example.myapplicationwithpaging3.adapter.general

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationwithpaging3.databinding.ErrorStateBinding

class LoadingStateAdapter
constructor(private val retry: () -> Unit) :
    LoadStateAdapter<LoadingStateAdapter.LoadingViewHolder>() {


    override fun onBindViewHolder(holder: LoadingViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadingViewHolder {
        return LoadingViewHolder(
            ErrorStateBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), retry
        )
    }

    class LoadingViewHolder(private val binding: ErrorStateBinding, retry: () -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.btnRetry.setOnClickListener {
                retry()
            }
        }

        fun bind(loadState: LoadState) {
            binding.apply {
                progressBar.isVisible = loadState is LoadState.Loading
                btnRetry.isVisible = loadState !is LoadState.Loading
                tvPleaseTryAgain.isVisible = loadState !is LoadState.Loading
            }
        }
    }
}