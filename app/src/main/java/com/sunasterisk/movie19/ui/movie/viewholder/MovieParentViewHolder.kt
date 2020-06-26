package com.sunasterisk.movie19.ui.movie.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.sunasterisk.movie19.BR
import com.sunasterisk.movie19.base.BaseViewHolder
import com.sunasterisk.movie19.data.model.MovieParent
import com.sunasterisk.movie19.databinding.MovieParentItemBinding
import com.sunasterisk.movie19.ui.movie.adapter.MovieAdapter

class MovieParentViewHolder(
    private val binding: MovieParentItemBinding,
    private val viewPool: RecyclerView.RecycledViewPool
) : BaseViewHolder<MovieParent>(binding.root) {

    init {
        binding.recyclerViewMovieParentItem.apply {
            setRecycledViewPool(viewPool)
            adapter = MovieAdapter().apply {
                setItemClick {
                }
            }
        }
    }

    override fun bindData(item: MovieParent) {
        super.bindData(item)
        binding.apply {
            setVariable(BR.movieParent, item)
            executePendingBindings()
        }
    }
}
