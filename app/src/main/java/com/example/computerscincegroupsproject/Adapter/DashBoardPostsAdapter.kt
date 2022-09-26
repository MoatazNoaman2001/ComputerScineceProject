package com.example.computerscincegroupsproject.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.computerscincegroupsproject.models.Post
import com.example.computerscincegroupsproject.databinding.SimplePostItemBinding

class DashBoardPostsAdapter : ListAdapter<Post, DashBoardPostsAdapter.ViewHolder?>(PostsDiffItemUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            SimplePostItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class ViewHolder(private val binding: SimplePostItemBinding) : RecyclerView.ViewHolder(binding.root) {

        public fun bind(post: Post) {
            var creator = binding.Creator.text.toString();
            if (!creator.contains(post.CreatorName))
                post.CreatorName.forEach { c -> creator += c }
            binding.Creator.text = creator
            binding.content.text = post.content
        }
    }

    class PostsDiffItemUtil : ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.uid == newItem.uid
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.CreatorName == newItem.CreatorName && oldItem.content == newItem.content
        }

    }

}



