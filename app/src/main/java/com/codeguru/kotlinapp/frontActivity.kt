package com.example.test.test

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.codeguru.kotlinapp.MainActivity
import com.codeguru.kotlinapp.R

class frontActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front)
        val bidButton = findViewById(R.id.sendBid1) as ImageButton
        bidButton.setOnClickListener() {
            val inputIntent = Intent(this@frontActivity,MainActivity::class.java
            )
            startActivity(inputIntent)
        }


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater= menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.settings -> {
            // User chose the "Settings" item, show the app settings UI...
            true
        }

        R.id.about -> {
            // User chose the "About" action...
            val aboutIntent= Intent(this@frontActivity,About::class.java)
            startActivity(aboutIntent)
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }
}
