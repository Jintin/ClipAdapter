package com.jintin.clipadapter.app

import android.view.LayoutInflater
import com.jintin.clipadapter.ClipViewData
import com.jintin.clipadapter.ClipViewHolder
import com.jintin.clipadapter.ViewHolderProvider
import com.jintin.clipadapter.app.databinding.AdapterIntBinding

data class IntViewData(val value: Int) : ClipViewData {
    override val viewHolder: ViewHolderProvider = {
        IntHolder(
            AdapterIntBinding.inflate(
                LayoutInflater.from(it.context),
                it,
                false
            )
        )
    }
}


class IntHolder(private val binding: AdapterIntBinding) :
    ClipViewHolder<IntViewData>(binding.root) {

    override fun onBind(viewData: IntViewData) {
        binding.intValue.text = viewData.value.toString()
    }
}