package com.sunasterisk.movie19.ui.movie

import androidx.recyclerview.widget.RecyclerView
import com.sunasterisk.movie19.BR
import com.sunasterisk.movie19.base.BaseViewHolder
import com.sunasterisk.movie19.data.model.MovieParent
import com.sunasterisk.movie19.databinding.MovieParentItemBinding

class MovieParentViewHolder(
    private val binding: MovieParentItemBinding,
    private val viewPool: RecyclerView.RecycledViewPool
) : BaseViewHolder<MovieParent>(
    binding.root
) {

    init {
        val adapter = MovieAdapter()
        binding.recyclerViewMovieParentItem.adapter = adapter
    }

    override fun bindData(item: MovieParent) {
        super.bindData(item)
        binding.apply {
            recyclerViewMovieParentItem.setRecycledViewPool(viewPool)
            setVariable(BR.movieParent, item)
            executePendingBindings()
        }
    }
}
