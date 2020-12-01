package com.jintin.clipadapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ClipViewHolder<T>(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    internal fun bind(viewData: Any) {
        onBind(viewData as T)
    }

    abstract fun onBind(viewData: T)

}