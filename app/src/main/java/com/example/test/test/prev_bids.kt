package com.example.test.test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_prev_bids.*

class prev_bids : AppCompatActivity() {
    val bids: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prev_bids)
        loadBids()
        recycler.layoutManager=LinearLayoutManager(this)
        recycler.adapter=MyAdapter(bids)

    }
    private fun loadBids(){
        val filename = "savedBids"
        val file=openFileInput(filename)
        file.bufferedReader().useLines {
            lines->lines.forEach { bids.add(it) }
        }


    }

}
