package com.sunasterisk.movie19.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sunasterisk.movie19.R
import com.sunasterisk.movie19.base.BaseAdapter
import com.sunasterisk.movie19.data.model.Movie
import com.sunasterisk.movie19.databinding.SearchMovieItemBinding
import com.sunasterisk.movie19.ui.search.viewholder.SearchMovieViewHolder

class SearchMovieAdapter : BaseAdapter<Movie, SearchMovieViewHolder>(SearchMovieDiffCallback()) {

    private lateinit var onItemClick: (Movie) -> Unit

    fun setItemClick(onItemClick: (Movie) -> Unit) {
        this.onItemClick = onItemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMovieViewHolder {
        val inflater = DataBindingUtil.inflate<SearchMovieItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.search_movie_item,
            parent,
            false
        )
        return SearchMovieViewHolder(inflater).apply { setItemClick(onItemClick) }
    }
}
