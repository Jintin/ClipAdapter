package com.jintin.clipadapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class ClipAdapter(diffCheck: DiffUtil.ItemCallback<ClipViewData<*>> = ClipDiffUtil) :
    ListAdapter<ClipViewData<*>, ClipViewHolder<*>>(diffCheck) {

    private val viewTypeMap = mutableMapOf<Class<ClipViewData<*>>, Int>()
    
    private val viewHolderMap = mutableMapOf<Int, ViewHolderProvider<*>>()

    override fun getItemViewType(position: Int): Int {
        val obj = getItem(position)
        return viewTypeMap[obj.javaClass] ?: viewTypeMap.size.also {
            viewTypeMap[obj.javaClass] = it
            viewHolderMap[it] = obj.holderProvider
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ClipViewHolder<*> {
        return viewHolderMap[viewType]?.invoke(parent)
            ?: throw RuntimeException("The viewType: $viewType is not support to generate ViewHolder")
    }

    override fun onBindViewHolder(holder: ClipViewHolder<*>, position: Int) {
        holder.bind(getItem(position).value)
    }
}

private object ClipDiffUtil : DiffUtil.ItemCallback<ClipViewData<*>>() {

    override fun areItemsTheSame(
        oldItem: ClipViewData<*>,
        newItem: ClipViewData<*>
    ) = oldItem::class == newItem::class

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: ClipViewData<*>,
        newItem: ClipViewData<*>
    ) = oldItem.value == newItem.value
}