package com.example.test.test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //ET=editText
        /*val nameET = findViewById(R.id.editText10)as EditText
        val phoneET = findViewById(R.id.editText11)as EditText
        val mailET = (R.id.editText12)as EditText
        val addresET = findViewById(R.id.editText13)as EditText
        val bidET = findViewById(R.id.editText14)as EditText*/
        val bidButton = findViewById(R.id.button)as Button
        bidButton.setOnClickListener() {
            Toast.makeText(this@MainActivity, "Bud skickat", Toast.LENGTH_SHORT).show()
            /*val userName=nameET.text
            val userPhone=phoneET.text
            val userMail=mailET.text
            val userAddres=addresET.text
            val userBid=bidET.text*/
            //skicka alla variabler till databasen
        }



    }





}
