package com.mahmudur.gitcommitviewer.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mahmudur.gitcommitviewer.R
import com.mahmudur.gitcommitviewer.model.dataModel

class CommitAdapter : PagingDataAdapter<dataModel.Commit, CommitAdapter.CommitViewHolder>(COMMIT_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommitViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_commit, parent, false)
        return CommitViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommitViewHolder, position: Int) {
        val commit = getItem(position)
        if (commit != null) {
            holder.bind(commit)
        }
    }

    class CommitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val commitMessageTextView: TextView = itemView.findViewById(R.id.commitMessageTextView)
        private val committerLoginTextView: TextView = itemView.findViewById(R.id.committerLoginTextView)
        private val committerAvatarImageView: ImageView = itemView.findViewById(R.id.committerAvatarImageView)

        fun bind(commit: dataModel.Commit) {
            commitMessageTextView.text = commit.message
            committerLoginTextView.text = commit.committer.login

            Glide.with(itemView)
                .load(commit.committer.avatarUrl)
                .into(committerAvatarImageView)
        }
    }

    companion object {
        private val COMMIT_COMPARATOR = object : DiffUtil.ItemCallback<dataModel.Commit>() {
            override fun areItemsTheSame(oldItem: dataModel.Commit, newItem: dataModel.Commit): Boolean {
                return oldItem.sha == newItem.sha
            }

            override fun areContentsTheSame(oldItem: dataModel.Commit, newItem: dataModel.Commit): Boolean {
                return oldItem == newItem
            }
        }
    }
}