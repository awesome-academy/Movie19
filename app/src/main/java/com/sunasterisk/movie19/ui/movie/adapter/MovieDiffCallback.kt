package com.sunasterisk.movie19.ui.movie.adapter

import androidx.recyclerview.widget.DiffUtil
import com.sunasterisk.movie19.data.model.Movie

class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {

    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
        oldItem.equals(newItem)

}
