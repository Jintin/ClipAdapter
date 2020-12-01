package com.jintin.clipadapter.app.obj

import android.graphics.Color
import android.view.LayoutInflater
import com.jintin.clipadapter.ClipViewData
import com.jintin.clipadapter.ClipViewHolder
import com.jintin.clipadapter.ViewHolderProvider
import com.jintin.clipadapter.app.databinding.AdapterColorBinding
import java.util.*

class ColorViewData(
    override val value: Int,
    override val holderProvider: ViewHolderProvider<Int> = ColorHolder.provider()
) : ClipViewData<Int> {

    companion object {
        private val COLOR_LIST = listOf(
            Color.GRAY,
            Color.LTGRAY,
            Color.RED,
            Color.GREEN,
            Color.BLUE,
            Color.YELLOW,
            Color.CYAN,
            Color.MAGENTA
        )

        fun create(index: Int): ColorViewData {
            return ColorViewData(COLOR_LIST[index % COLOR_LIST.size])
        }
    }
}

class ColorHolder(private val binding: AdapterColorBinding) :
    ClipViewHolder<Int>(binding.root) {

    override fun onBind(value: Int) {
        binding.value.setTextColor(value)
        binding.value.text =
            Integer.toHexString(value).toUpperCase(Locale.ENGLISH)
    }

    companion object {
        fun provider(): ViewHolderProvider<Int> = {
            ColorHolder(
                AdapterColorBinding.inflate(
                    LayoutInflater.from(it.context),
                    it,
                    false
                )
            )
        }
    }
}