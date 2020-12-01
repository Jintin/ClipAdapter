package com.jintin.clipadapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ClipViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    @Suppress("UNCHECKED_CAST")
    internal fun bind(value: Any?) {
        (value as? T)?.let(::onBind) ?: run {
            Log.e("ClipAdapter", "ClipViewHolder is fail to bind $value due to type inconsistent")
        }
    }

    abstract fun onBind(value: T)

}