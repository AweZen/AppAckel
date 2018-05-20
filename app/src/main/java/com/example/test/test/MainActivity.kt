package com.example.test.test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import org.json.JSONException
import org.json.JSONObject

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
        val userName= findViewById(R.id.editText10)as EditText
        val userPhone=findViewById(R.id.editText11)as EditText
        val userMail=findViewById(R.id.editText12)as EditText
        val userAddres=findViewById(R.id.editText13)as EditText
        val userBid=findViewById(R.id.editText14)as EditText
        val bidButton = findViewById(R.id.button)as Button
        bidButton.setOnClickListener() {
            Toast.makeText(this@MainActivity, "Bud skickat", Toast.LENGTH_SHORT).show()
            /*      val userName= findViewById(R.id.editText10)as EditText
            val userPhone=findViewById(R.id.editText11)as EditText
            val userMail=findViewById(R.id.editText12)as EditText
            val userAddres=findViewById(R.id.editText13)as EditText
            val userBid=findViewById(R.id.editText14)as EditText    */
        }
        fun addArtist() {
            //getting the record values
            val name = userName?.text.toString()
            val phone = userPhone?.text.toString()
            val mail = userMail?.text.toString()
            val adress = userAddres?.text.toString()
            val bid = userBid?.text.toString()

            //creating volley string request
            val stringRequest = object : StringRequest(Request.Method.POST, EndPoints.URL_ADD_BID,
                    Response.Listener<String> { response ->
                        try {
                            val obj = JSONObject(response)
                            Toast.makeText(applicationContext, obj.getString("message"), Toast.LENGTH_LONG).show()
                        } catch (e: JSONException) {
                            e.printStackTrace()
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
                }
            }

            //adding request to queue
            VolleySingleton.instance?.addToRequestQueue(stringRequest)
        }



    }




}
