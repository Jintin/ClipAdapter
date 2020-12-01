package com.jintin.clipadapter.app

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.jintin.clipadapter.ClipViewData
import com.jintin.clipadapter.ClipViewHolder
import com.jintin.clipadapter.ViewHolderProvider

data class CharViewData(val value: Char) : ClipViewData {
    override val viewHolder: ViewHolderProvider = {
        CharHolder(
            LayoutInflater.from(it.context).inflate(
                R.layout.adapter_char,
                it,
                false
            )
        )
    }
}

class CharHolder(itemView: View) :
    ClipViewHolder<CharViewData>(itemView) {

    private val charValue = itemView.findViewById<TextView>(R.id.char_value)

    override fun onBind(viewData: CharViewData) {
        charValue.text = viewData.value.toString()
    }
}