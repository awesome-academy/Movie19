package com.sunasterisk.movie19.ui.search.viewholder

import com.sunasterisk.movie19.BR
import com.sunasterisk.movie19.base.BaseViewHolder
import com.sunasterisk.movie19.data.model.Movie
import com.sunasterisk.movie19.databinding.SearchMovieItemBinding

class SearchMovieViewHolder(
    private val databinding : SearchMovieItemBinding
): BaseViewHolder<Movie>(databinding.root) {
    override fun bindData(item: Movie) {
        super.bindData(item)
        databinding.apply {
            setVariable(BR.searchMovie,item)
            executePendingBindings()
            textViewNameMovie.isSelected = true
        }
    }
}
