package com.jintin.clipadapter.app.obj

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.jintin.clipadapter.ClipViewData
import com.jintin.clipadapter.ClipViewHolder
import com.jintin.clipadapter.ViewHolderProvider
import com.jintin.clipadapter.app.R

class CharViewData(
    override val value: Char,
    override val holderProvider: ViewHolderProvider<Char> = CharHolder.provider()
) : ClipViewData<Char>

class CharHolder(itemView: View) : ClipViewHolder<Char>(itemView) {

    private val title = itemView.findViewById<TextView>(R.id.title)

    override fun onBind(value: Char) {
        title.text = value.toString()
    }

    companion object {
        fun provider(): ViewHolderProvider<Char> = {
            CharHolder(
                LayoutInflater.from(it.context)
                    .inflate(R.layout.adapter_char, it, false)
            )
        }
    }
}