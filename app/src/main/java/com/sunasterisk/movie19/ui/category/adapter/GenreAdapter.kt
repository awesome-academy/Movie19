package com.sunasterisk.movie19.ui.category.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sunasterisk.movie19.R
import com.sunasterisk.movie19.base.BaseAdapter
import com.sunasterisk.movie19.data.model.Genre
import com.sunasterisk.movie19.databinding.GenreItemBinding
import com.sunasterisk.movie19.ui.category.viewholder.GenreViewHolder

class GenreAdapter : BaseAdapter<Genre, GenreViewHolder>(GenreDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val inflater = DataBindingUtil.inflate<GenreItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.genre_item,
            parent,
            false
        )
        return GenreViewHolder(inflater)
    }
}
