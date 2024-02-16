package com.example.xpera.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.xpera.databinding.ItemPostBinding
import com.example.xpera.domain.model.Post

class PostAdapter() : ListAdapter<Post, PostAdapter.ViewHolder>(DiffCallback) {

    inner class ViewHolder(
        private val binding: ItemPostBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {
            binding.postUserProfileImage.load(
                post.userProfileImageUrl?.toUri()?.buildUpon()?.scheme("https")?.build()
            )
            binding.postUserName.text = post.userName
            binding.postDate.text = post.date
            binding.postTitle.text = post.title
            binding.postContent.text = post.content
            val adapter = TagAdapter()
            binding.tagRecyclerView.adapter=adapter
            adapter.submitList(post.tags)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }


    object DiffCallback : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.content == newItem.content
        }

    }
}