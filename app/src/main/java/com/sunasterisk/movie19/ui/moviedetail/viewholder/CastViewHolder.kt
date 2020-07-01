package com.sunasterisk.movie19.ui.moviedetail.viewholder

import com.sunasterisk.movie19.BR
import com.sunasterisk.movie19.base.BaseViewHolder
import com.sunasterisk.movie19.data.model.Cast
import com.sunasterisk.movie19.databinding.CastItemBinding

class CastViewHolder(
    private val databinding: CastItemBinding
) : BaseViewHolder<Cast>(databinding.root) {

    override fun bindData(item: Cast) {
        super.bindData(item)
        databinding.apply {
            setVariable(BR.cast, item)
            executePendingBindings()
            textViewMovie.isSelected = true
        }
    }
}
