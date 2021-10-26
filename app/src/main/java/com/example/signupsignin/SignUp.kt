package com.example.signupsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUp : AppCompatActivity() {
    lateinit var name:EditText
    lateinit var username:EditText
    lateinit var mobile:EditText
    lateinit var password:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        name=findViewById(R.id.name)
        username=findViewById(R.id.username)
        mobile=findViewById(R.id.mobile)
        password=findViewById(R.id.password)
        var dbhr=DBHlpr(applicationContext)
        var signupbtn=findViewById<Button>(R.id.button3)
        signupbtn.setOnClickListener {

          var check= dbhr.savedat(name.text.toString(),username.text.toString(),mobile.text.toString(),password.text.toString())
            if(check<0)
            {Toast.makeText(this, "Your Account Has been Created Successfully", Toast.LENGTH_SHORT).show()
            val intent= Intent(this,Details::class.java)
            intent.putExtra("UserName",username.text.toString())
            startActivity(intent)}
            else{
                Toast.makeText(this, "Your UserName Already Used", Toast.LENGTH_SHORT).show()
            }
        }
    }
}