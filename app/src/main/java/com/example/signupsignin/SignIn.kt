package com.example.signupsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        var username=findViewById<EditText>(R.id.userName)
        var password=findViewById<EditText>(R.id.passwordd)
        var signinbtn=findViewById<Button>(R.id.signIn)
        var dbhr=DBHlpr(applicationContext)
        signinbtn.setOnClickListener {
           val check= dbhr.check(username.text.toString(),password.text.toString())
            if (check==0) {
                Toast.makeText(this, "Your Password Is Wrong", Toast.LENGTH_SHORT).show()
            }
            else if(check>0){
                val intent= Intent(this,Details::class.java)
                intent.putExtra("UserName",username.text.toString())
                startActivity(intent)

            }
            else{
                Toast.makeText(this, "This UserName Does Not Exist", Toast.LENGTH_SHORT).show()
            }

            }
        }
    }
