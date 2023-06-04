package com.example.phone1cr20cs109

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.net.Uri
import android.provider.ContactsContract
import android.content.Intent

class MainActivity : AppCompatActivity() {

    private lateinit var dialspace: TextView
    private  lateinit var one : TextView
    private  lateinit var two : TextView
    private  lateinit var three : TextView
    private  lateinit var four : TextView
    private  lateinit var five : TextView
    private  lateinit var six : TextView
    private  lateinit var seven : TextView
    private  lateinit var eight : TextView
    private  lateinit var nine : TextView
    private  lateinit var zero : TextView
    private  lateinit var clear : TextView
    private lateinit var star : TextView
    private lateinit var hash : TextView
    private lateinit var call : Button
    private lateinit var save : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        zero = findViewById(R.id.zero)
        clear = findViewById(R.id.clear)
        star = findViewById(R.id.star)
        hash = findViewById(R.id.hash)
        call = findViewById(R.id.call)
        save = findViewById(R.id.save)
        dialspace = findViewById(R.id.dialspace)

        zero.setOnClickListener{
            pressButton("0",true)
        }

        one.setOnClickListener{
            pressButton("1",true)
        }

        two.setOnClickListener{
            pressButton("2",true)
        }

        three.setOnClickListener{
            pressButton("3",true)
        }

        four.setOnClickListener{
            pressButton("4",true)
        }

        five.setOnClickListener{
            pressButton("5",true)
        }

        six.setOnClickListener{
            pressButton("6",true)
        }

        seven.setOnClickListener{
            pressButton("7",true)
        }

        eight.setOnClickListener{
            pressButton("8",true)
        }

        nine.setOnClickListener{
            pressButton("9",true)
        }

        star.setOnClickListener {
            pressButton("*",true)
        }

        hash.setOnClickListener {
            pressButton("#",true)
        }

        clear.setOnClickListener {
            dialspace.text = ""
        }

        call.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            val uri = Uri.parse("tel:" + dialspace.text)
            intent.data = uri
            startActivity(intent)
        }


        save.setOnClickListener {
            val intent = Intent(ContactsContract.Intents.Insert.ACTION)
            intent.type = ContactsContract.RawContacts.CONTENT_TYPE
            intent.putExtra(ContactsContract.Intents.Insert.PHONE, dialspace.text)
            startActivity(intent)
        }
    }
    fun pressButton(s: String, b: Boolean){
        if(b){
            dialspace.append(s)
        }
    }
}