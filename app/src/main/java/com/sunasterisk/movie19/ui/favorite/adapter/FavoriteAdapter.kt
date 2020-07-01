package com.sunasterisk.movie19.ui.favorite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sunasterisk.movie19.R
import com.sunasterisk.movie19.base.BaseAdapter
import com.sunasterisk.movie19.data.model.Favorite
import com.sunasterisk.movie19.databinding.MovieFavoriteItemBinding
import com.sunasterisk.movie19.ui.favorite.viewholder.FavoriteViewHolder

class FavoriteAdapter : BaseAdapter<Favorite, FavoriteViewHolder>(FavoriteDiffCallback()) {

    private lateinit var onItemClick: (Favorite) -> Unit

    fun setItemClick(onItemClick: (Favorite) -> Unit) {
        this.onItemClick = onItemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val inflater = DataBindingUtil.inflate<MovieFavoriteItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.movie_favorite_item,
            parent,
            false
        )
        return FavoriteViewHolder(inflater).apply { setItemClick(onItemClick) }
    }
}
