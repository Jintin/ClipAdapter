package com.jintin.clipadapter

import android.view.ViewGroup

interface ClipViewData<T> {

    val value: T

    val holderProvider: ViewHolderProvider<T>
}

typealias ViewHolderProvider<T> = (parent: ViewGroup) -> ClipViewHolder<T>