package com.example.gitpullrequest.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gitpullrequest.R
import com.example.gitpullrequest.databinding.ItemPullRequestBinding

class PullRequestAdapter: ListAdapter<PullRequest, PullRequestAdapter.ViewHolder>(
    PullRequestDiffUtil
) {

    class ViewHolder(private val binding: ItemPullRequestBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PullRequest) {
            binding.item = data
//            binding.executePendingBindings()
        }
    }

    object PullRequestDiffUtil: DiffUtil.ItemCallback<PullRequest>() {
        override fun areItemsTheSame(oldItem: PullRequest, newItem: PullRequest): Boolean {
            return oldItem.number == newItem.number
        }

        override fun areContentsTheSame(oldItem: PullRequest, newItem: PullRequest): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_pull_request, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}