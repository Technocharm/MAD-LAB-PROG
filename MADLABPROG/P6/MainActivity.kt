package com.example.texttospeech1cr20cs109

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.EditText
import java.util.*

class MainActivity : AppCompatActivity() ,TextToSpeech.OnInitListener{
    private lateinit var textInfo: EditText
    private lateinit var speak:Button
    private lateinit var textToSpeech:TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textInfo=findViewById(R.id.text)
        speak=findViewById(R.id.speak)
        textToSpeech=TextToSpeech(this,this)
        speak.setOnClickListener {
            textToSpeech.speak(textInfo.text.toString(),TextToSpeech.QUEUE_FLUSH,null," ")
        }
    }

    override fun onInit(status: Int) {
        if (status==TextToSpeech.SUCCESS){
            Log.d("msg","Success")
            textToSpeech.setLanguage(Locale.ENGLISH)
        }
        else{
            Log.d("msg","Failed")
        }
    }
}