package com.jintin.clipadapter.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jintin.clipadapter.ClipAdapter

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    @ExperimentalStdlibApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = ClipAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val list = buildList {
            for (i in 0..128) {
                add(IntViewData(i))
                add(CharViewData(' ' + i))
            }
        }
        adapter.submitList(list)
    }
}