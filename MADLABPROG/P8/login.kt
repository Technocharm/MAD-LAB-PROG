package com.example.loginsignup1cr20cs109

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class login : AppCompatActivity() {

    lateinit var loginusername : EditText
    lateinit var loginpassword : EditText
    lateinit var loginbutton : Button
    var count : Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginusername=findViewById(R.id.luname)
        loginpassword=findViewById(R.id.lpass)
        loginbutton = findViewById(R.id.lbtn)
        val bundle : Bundle? = intent.extras
        val uname : String? = bundle?.getString("username")
        val pwd : String? = bundle?.getString("password")

        loginbutton.setOnClickListener {
            validate(uname,pwd)
        }
    }

    private fun validate(uname : String?,pwd : String?)
    {
        val user : String = loginusername.text.toString()
        val pass : String = loginpassword.text.toString()

        if(user==uname && pass==pwd)
        {
            Toast.makeText(this,"Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,success::class.java)
            startActivity(intent)
        }
        else
        {
            count++
            if(count>2)
            {
                loginbutton.isEnabled=false
                Toast.makeText(this,"Failed login attempts", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this,"Login failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}