package com.jintin.clipadapter.app.obj

import android.view.LayoutInflater
import com.jintin.clipadapter.ClipViewData
import com.jintin.clipadapter.ClipViewHolder
import com.jintin.clipadapter.ViewHolderProvider
import com.jintin.clipadapter.app.databinding.AdapterStringBinding

class StringViewData(
    override val value: String,
    itemClickListener: OnItemClickListener,
) : ClipViewData<String> {

    override val holderProvider: ViewHolderProvider<String> =
        StringHolder.provider(itemClickListener)
}

interface OnItemClickListener {
    fun onClick(value: String)
}

private class StringHolder(
    private val binding: AdapterStringBinding,
    private val itemClickListener: OnItemClickListener
) : ClipViewHolder<String>(binding.root) {

    override fun onBind(value: String) {
        binding.title.text = value
        binding.root.setOnClickListener {
            itemClickListener.onClick(value)
        }
    }

    companion object {
        fun provider(stringItemClickListener: OnItemClickListener): ViewHolderProvider<String> =
            {
                StringHolder(
                    AdapterStringBinding.inflate(
                        LayoutInflater.from(it.context),
                        it,
                        false
                    ), stringItemClickListener
                )
            }
    }
}