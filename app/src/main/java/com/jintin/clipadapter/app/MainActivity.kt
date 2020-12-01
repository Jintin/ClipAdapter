package com.jintin.clipadapter.app

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jintin.clipadapter.ClipAdapter
import com.jintin.clipadapter.ClipViewData
import com.jintin.clipadapter.app.obj.CharViewData
import com.jintin.clipadapter.app.obj.ColorViewData
import com.jintin.clipadapter.app.obj.OnItemClickListener
import com.jintin.clipadapter.app.obj.StringViewData

class MainActivity : AppCompatActivity(R.layout.activity_main), OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = ClipAdapter()
        adapter.submitList(getData())

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun getData(): List<ClipViewData<*>> {
        val list = mutableListOf<ClipViewData<*>>()
        for (i in 0..25) {
            list.add(StringViewData("#$i Item", this))
            list.add(CharViewData('A' + i))
            list.add(ColorViewData.create(i))
        }
        return list.toList()
    }

    override fun onClick(value: String) {
        Toast.makeText(this, "You click $value", Toast.LENGTH_SHORT).show()
    }
}