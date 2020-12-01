package com.jintin.clipadapter.app

import android.graphics.Color
import android.view.LayoutInflater
import com.jintin.clipadapter.ClipViewData
import com.jintin.clipadapter.ClipViewHolder
import com.jintin.clipadapter.ViewHolderProvider
import com.jintin.clipadapter.app.databinding.AdapterColorBinding
import java.util.*

data class ColorViewData(val value: Int) : ClipViewData {

    override val viewHolder: ViewHolderProvider = {
        ColorHolder(
            AdapterColorBinding.inflate(
                LayoutInflater.from(it.context),
                it,
                false
            )
        )
    }

    class ColorHolder(private val binding: AdapterColorBinding) :
        ClipViewHolder<ColorViewData>(binding.root) {

        override fun onBind(viewData: ColorViewData) {
            binding.root.setBackgroundColor(viewData.value)
            binding.value.text =
                Integer.toHexString(viewData.value).toUpperCase(Locale.ENGLISH)
        }
    }

    companion object {
        val COLOR_LIST = listOf(
            Color.BLACK,
            Color.GRAY,
            Color.LTGRAY,
            Color.RED,
            Color.GREEN,
            Color.BLUE,
            Color.YELLOW,
            Color.CYAN,
            Color.MAGENTA
        )
    }
}