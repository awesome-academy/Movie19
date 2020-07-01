package com.sunasterisk.movie19.ui.favorite.adapter

import androidx.recyclerview.widget.DiffUtil
import com.sunasterisk.movie19.data.model.Favorite

class FavoriteDiffCallback : DiffUtil.ItemCallback<Favorite>() {
    override fun areItemsTheSame(oldItem: Favorite, newItem: Favorite): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Favorite, newItem: Favorite): Boolean =
        oldItem.nameMovie == newItem.nameMovie
}
