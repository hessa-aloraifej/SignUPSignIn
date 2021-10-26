package com.example.signupsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        var name=findViewById<TextView>(R.id.textView)
        var details=findViewById<TextView>(R.id.textView2)
        var signout=findViewById<Button>(R.id.button4)
        var  dbhr=DBHlpr(applicationContext)
        val nam = intent.getStringExtra("UserName")
        val info=dbhr.read(nam.toString())
        name.text="Welcom,${info[0]}"
        details.text="\n\nYour Details :\n\n Your Name:${info[0]}\n\n Your UserName:${info[2]}\n\n Your Mobile No:${info[1]}"
       signout.setOnClickListener {
           val intent= Intent(this,SignIn::class.java)

           startActivity(intent)
       }
    }
}