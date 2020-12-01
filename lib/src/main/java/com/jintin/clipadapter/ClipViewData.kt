package com.jintin.clipadapter

import android.view.ViewGroup


interface ClipViewData {

    val viewHolder: ViewHolderProvider
}
typealias ViewHolderProvider = (parent: ViewGroup) -> ClipViewHolder<*>