package com.example.test.test

import android.app.Application
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.view.Menu
import android.view.MenuItem
import android.content.Intent
import android.graphics.Color
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import org.json.JSONException
import org.json.JSONObject
import android.graphics.drawable.ColorDrawable
import java.io.File


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bidButton = findViewById(R.id.button) as Button
        bidButton.setOnClickListener() {
            Toast.makeText(this@MainActivity, "Bud skickat", Toast.LENGTH_SHORT).show()
            saveToFile()
        }
    }
    private fun saveToFile(){
        val adress = findViewById<EditText>(R.id.editText13).text.toString()
        val bid = findViewById<EditText>(R.id.editText14).text.toString()
        val filename = "savedBids"
        val fileContents = adress+" "+bid+"\n"
        applicationContext.openFileOutput(filename,Application.MODE_PRIVATE).use {
            it.write(fileContents.toByteArray())
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater= menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    fun addArtist() {
        //getting the record values

        val name = findViewById<EditText>(R.id.editText10).text.toString()
        val phone = findViewById<EditText>(R.id.editText11).text.toString()
        val mail = findViewById<EditText>(R.id.editText12).text.toString()
        val adress = findViewById<EditText>(R.id.editText13).text.toString()
        val bid = findViewById<EditText>(R.id.editText14).text.toString()

        //creating volley string request
        val stringRequest = object : StringRequest(Request.Method.POST, EndPoints.URL_ADD_BID,
                Response.Listener<String> { response ->
                    try {
                        val obj = JSONObject(response)
                        Toast.makeText(this@MainActivity, "test", Toast.LENGTH_LONG).show()
                        Log.d("myTag", "Tryy")
                    } catch (e: JSONException) {
                        e.printStackTrace()
                        Log.d("myTag", "catch")
                    }
                },
                object : Response.ErrorListener {
                    override fun onErrorResponse(volleyError: VolleyError) {
                        Toast.makeText(applicationContext, volleyError.message, Toast.LENGTH_LONG).show()
                    }
                }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params.put("Namn", name)
                params.put("Telefon", phone)
                params.put("Mail", mail)
                params.put("Adress", adress)
                params.put("Bud", bid)
                return params
                Log.d("myTag","test")
            }
        }

        //adding request to queue
        VolleySingleton.instance?.addToRequestQueue(stringRequest)
    }








}
