package com.sunasterisk.movie19.ui.search.adapter

import androidx.recyclerview.widget.DiffUtil
import com.sunasterisk.movie19.data.model.Movie

class SearchMovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
        oldItem.title == newItem.title
}
