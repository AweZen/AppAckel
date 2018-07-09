package com.example.test.test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class About : AppCompatActivity() {
    //kanske inte behöver vara en activity?
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }
}
