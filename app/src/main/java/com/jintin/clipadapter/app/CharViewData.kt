package com.jintin.clipadapter.app

import android.view.LayoutInflater
import com.jintin.clipadapter.ClipViewData
import com.jintin.clipadapter.ClipViewHolder
import com.jintin.clipadapter.ViewHolderProvider
import com.jintin.clipadapter.app.databinding.AdapterCharBinding

data class CharViewData(val value: Char) : ClipViewData {
    override val viewHolder: ViewHolderProvider = {
        CharHolder(
            AdapterCharBinding.inflate(
                LayoutInflater.from(it.context),
                it,
                false
            )
        )
    }
}


class CharHolder(private val binding: AdapterCharBinding) :
    ClipViewHolder<CharViewData>(binding.root) {

    override fun onBind(viewData: CharViewData) {
        binding.charValue.text = viewData.value.toString()
    }
}