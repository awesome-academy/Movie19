package com.sunasterisk.movie19.ui.movie.adapter

import androidx.recyclerview.widget.DiffUtil
import com.sunasterisk.movie19.data.model.MovieParent

class MovieParentDiffCallback : DiffUtil.ItemCallback<MovieParent>() {

    override fun areItemsTheSame(oldItem: MovieParent, newItem: MovieParent): Boolean =
        oldItem.nameCategory == newItem.nameCategory

    override fun areContentsTheSame(oldItem: MovieParent, newItem: MovieParent): Boolean =
        oldItem.nameCategory == newItem.nameCategory
}
