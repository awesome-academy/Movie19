package com.sunasterisk.movie19.ui.category.adapter

import androidx.recyclerview.widget.DiffUtil
import com.sunasterisk.movie19.data.model.Genre

class GenreDiffCallback : DiffUtil.ItemCallback<Genre>() {
    override fun areItemsTheSame(oldItem: Genre, newItem: Genre): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Genre, newItem: Genre): Boolean =
        oldItem.name == newItem.name
}
