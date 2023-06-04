package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset
import javax.xml.parsers.DocumentBuilderFactory

class MainActivity : AppCompatActivity() {
    private lateinit var json : Button
    private lateinit var xml : Button
    private lateinit var city : TextView
    private lateinit var lat : TextView
    private lateinit var lon : TextView
    private lateinit var temp : TextView
    private lateinit var hum : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        json = findViewById(R.id.json)
        xml = findViewById(R.id.xml)
        city = findViewById(R.id.city)
        lat = findViewById(R.id.lat)
        lon = findViewById(R.id.lon)
        temp = findViewById(R.id.temp)
        hum = findViewById(R.id.hum)

        json.setOnClickListener { parsejson() }
        xml.setOnClickListener { parsexml() }


    }

    private fun parsexml(){
        val input = assets.open("myxml.xml")
        val dbf = DocumentBuilderFactory.newInstance()
        val docbuild = dbf.newDocumentBuilder()
        val doc = docbuild.parse(input)
        city.text = doc.getElementsByTagName("city").item(0).firstChild.nodeValue
        lat.text = doc.getElementsByTagName("lat").item(0).firstChild.nodeValue
        lon.text = doc.getElementsByTagName("lon").item(0).firstChild.nodeValue
        temp.text = doc.getElementsByTagName("temp").item(0).firstChild.nodeValue
        hum.text = doc.getElementsByTagName("hum").item(0).firstChild.nodeValue
    }

    private fun parsejson(){
        val obj = JSONObject(jparse())
        city.text = obj.getString("city")
        lat.text = obj.getString("lat")
        lon.text = obj.getString("lon")
        temp.text = obj.getString("temp")
        hum.text = obj.getString("hum")
    }

    private fun jparse() : String{
        val json : String
        try{
            val input = assets.open("myjson.json")
            val size = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            input.close()
            val charset : Charset = Charsets.UTF_8
            json = String(buffer, charset)
        }catch (ex : IOException){
            return ""
        }
        return json
    }
}