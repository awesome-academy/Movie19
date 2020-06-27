package com.sunasterisk.movie19.ui.moviedetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sunasterisk.movie19.R
import com.sunasterisk.movie19.base.BaseAdapter
import com.sunasterisk.movie19.data.model.Cast
import com.sunasterisk.movie19.databinding.CastItemBinding
import com.sunasterisk.movie19.ui.moviedetail.viewholder.CastViewHolder

class CastAdapter : BaseAdapter<Cast, CastViewHolder>(CastDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val inflater = DataBindingUtil.inflate<CastItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.cast_item,
            parent,
            false
        )
        return CastViewHolder(inflater)
    }
}
