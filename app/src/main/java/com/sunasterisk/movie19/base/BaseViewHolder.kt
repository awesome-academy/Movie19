package com.sunasterisk.movie19.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(
    view: View
) : RecyclerView.ViewHolder(view) {

    protected lateinit var onItemClick: (T) -> Unit
    private var item: T? = null

    init {
        itemView.setOnClickListener {
            item?.let { onItemClick(it) }
        }
    }

    open fun setItemClick(onItemClick: (T) -> Unit) {
        this.onItemClick = onItemClick
    }

    open fun bindData(item: T) {
        this.item = item
    }
}
