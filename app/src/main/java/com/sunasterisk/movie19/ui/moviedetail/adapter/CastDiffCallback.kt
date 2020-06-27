package com.sunasterisk.movie19.ui.moviedetail.adapter

import androidx.recyclerview.widget.DiffUtil
import com.sunasterisk.movie19.data.model.Cast

class CastDiffCallback : DiffUtil.ItemCallback<Cast>() {
    override fun areItemsTheSame(oldItem: Cast, newItem: Cast): Boolean =
        oldItem.castId == newItem.castId

    override fun areContentsTheSame(oldItem: Cast, newItem: Cast): Boolean =
        oldItem.name == newItem.name
}
