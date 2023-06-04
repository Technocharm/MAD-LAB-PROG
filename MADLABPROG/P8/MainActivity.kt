package com.example.loginsignup1cr20cs109

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Matcher
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    lateinit var signupusername : EditText
    lateinit var signuppassword : EditText
    lateinit var signupbutton : Button
    val re = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{8,}$"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        signupusername = findViewById(R.id.suname)
        signuppassword = findViewById(R.id.spass)
        signupbutton = findViewById(R.id.sbtn)

        signupbutton.setOnClickListener {
            getdetails()
        }
    }

    private fun getdetails() {
        val uname : String = signupusername.text.toString()
        val pwd : String = signuppassword.text.toString()

        if(validate(pwd))
        {
            Toast.makeText(this,"Signup successful", Toast.LENGTH_SHORT).show()
            val bundle = Bundle()
            bundle.putString("username",uname)
            bundle.putString("password",pwd)
            val intent = Intent(this,login::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        else
        {
            Toast.makeText(this,"Invalid format", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validate(pwd : String) : Boolean {
        val pattern : Pattern = Pattern.compile(re)
        val matcher : Matcher = pattern.matcher(pwd)
        return matcher.matches()

    }
}