package com.jintin.clipadapter.app.obj

import android.view.LayoutInflater
import com.jintin.clipadapter.ClipViewData
import com.jintin.clipadapter.ClipViewHolder
import com.jintin.clipadapter.ViewHolderProvider
import com.jintin.clipadapter.app.databinding.AdapterStringBinding

class StringViewData(
    override val value: String,
    override val holderProvider: ViewHolderProvider<String> = StringHolder.provider()
) : ClipViewData<String>

class StringHolder(private val binding: AdapterStringBinding) :
    ClipViewHolder<String>(binding.root) {

    override fun onBind(value: String) {
        binding.title.text = value
    }

    companion object {
        fun provider(): ViewHolderProvider<String> = {
            StringHolder(
                AdapterStringBinding.inflate(
                    LayoutInflater.from(it.context),
                    it,
                    false
                )
            )
        }
    }
}