package com.sunasterisk.movie19.ui.favorite.viewholder

import com.sunasterisk.movie19.BR
import com.sunasterisk.movie19.base.BaseViewHolder
import com.sunasterisk.movie19.data.model.Favorite
import com.sunasterisk.movie19.databinding.MovieFavoriteItemBinding

class FavoriteViewHolder(
    private val databinding: MovieFavoriteItemBinding
) : BaseViewHolder<Favorite>(databinding.root) {
    override fun bindData(item: Favorite) {
        super.bindData(item)
        databinding.apply {
            setVariable(BR.favoriteMovie, item)
            executePendingBindings()
            textViewMovie.isSelected = true
        }
    }
}
