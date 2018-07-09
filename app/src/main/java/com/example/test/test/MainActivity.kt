package com.example.test.test


import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    private var editTextName: EditText? = null
    private var editTextTelefon: EditText? = null
    private var editTextMail: EditText? = null
    private var editTextAdress: EditText? = null
    private var editTextBid: EditText? = null
    private var button: Button? = null


    private val URL = "http://192.168.1.182/WebApi/v1/employee.php"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextName = findViewById(R.id.editText10) as EditText
        editTextTelefon = findViewById(R.id.editText11) as EditText
        editTextMail = findViewById(R.id.editText12) as EditText
        editTextAdress= findViewById(R.id.editText13) as EditText
        editTextBid = findViewById(R.id.editText14) as EditText

        button = findViewById(R.id.button) as Button
        button?.setOnClickListener({sendData()})

    }
    private fun sendData() {

        val stringRequest = object: StringRequest(Request.Method.POST, "http://192.168.1.182/WebApi/v1/employee.php",
                Response.Listener<String>{response ->


                    //)   val obj = JSONObject(response)


                }, object: Response.ErrorListener{

            override fun onErrorResponse(p0: VolleyError?) {

                Toast.makeText(applicationContext, p0?.message, Toast.LENGTH_LONG).show()

            }
        })
        {
            override fun getParams(): MutableMap<String, String> {

                val params = HashMap<String, String>()

                params.put("name", editTextName?.text.toString())
                params.put("position", editTextTelefon?.text.toString())
                params.put("salary", editTextMail?.text.toString())
                params.put("experience", editTextAdress?.text.toString())
                params.put("bid", editTextBid?.text.toString())

                return params
            }
        }

        VolleySingleton.instance?.addToRequestQueue(stringRequest)


    }
}





