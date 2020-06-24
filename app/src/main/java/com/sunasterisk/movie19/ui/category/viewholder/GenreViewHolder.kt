package com.sunasterisk.movie19.ui.category.viewholder

import com.sunasterisk.movie19.BR
import com.sunasterisk.movie19.base.BaseViewHolder
import com.sunasterisk.movie19.data.model.Genre
import com.sunasterisk.movie19.databinding.GenreItemBinding

class GenreViewHolder(private val databinding: GenreItemBinding): BaseViewHolder<Genre>(databinding.root) {
    override fun bindData(item: Genre) {
        super.bindData(item)
        databinding.apply {
            setVariable(BR.genre,item)
            executePendingBindings()
        }
    }
}
