package com.example.signupsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val signInbtn=findViewById<Button>(R.id.button)
        val signUpbtn=findViewById<Button>(R.id.button2)
        signInbtn.setOnClickListener {
            val intent= Intent(this,SignIn::class.java)
            startActivity(intent)
        }
        signUpbtn.setOnClickListener {
            val intent= Intent(this,SignUp::class.java)
            startActivity(intent)
        }
    }
}