package com.example.formvaldemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUserName : EditText = findViewById(R.id.etUserName)
        val etPinNo : EditText = findViewById(R.id.etPinNo)

        val btlogin : Button = findViewById(R.id.btlogin)
        val btclear : Button = findViewById(R.id.btclear)

        btlogin.setOnClickListener {
            val checkUserName = "[a-zA-Z]+".toRegex()
            val checkPinNo = "[0-9]{4}".toRegex()

            if(checkUserName.matches(etUserName.text.toString()) &&
                    checkPinNo.matches(etPinNo.text.toString()))
            {
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this@MainActivity,"Invalid username and pin number",Toast.LENGTH_SHORT).show()
            }
        }
        btclear.setOnClickListener {
            etUserName.setText("")
            etPinNo.setText("")
        }
    }
}