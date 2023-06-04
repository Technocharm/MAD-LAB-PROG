package com.example.counter1cr20cs109

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var countervalue : TextView
    lateinit var startbtn : Button
    lateinit var stopbtn : Button
    lateinit var resetbtn : Button

    val timer = Mycounter(1000000,1000)
    //var count : Double = 0.0
    var count : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        countervalue = findViewById(R.id.c_val)
        startbtn = findViewById(R.id.startbtn)
        stopbtn = findViewById(R.id.stopbtn)
        resetbtn = findViewById(R.id.resetbtn)


        startbtn.setOnClickListener {
            timer.start()
            startbtn.isEnabled = false
        }

        stopbtn.setOnClickListener {
            timer.cancel()
            startbtn.isEnabled = true
        }

        resetbtn.setOnClickListener {
            timer.cancel()
            startbtn.isEnabled = true
            count=0
            countervalue.text = (count).toString()
        }
    }

    inner class Mycounter (x:Long,y:Long) : CountDownTimer(x,y){

        override fun onTick(millisUntilFinished: Long) {
            count+=1
            countervalue.text = (count).toString()
        }

        override fun onFinish() {
            countervalue.text = "Finished"
        }
    }
}