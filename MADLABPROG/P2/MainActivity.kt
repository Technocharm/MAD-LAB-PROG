package com.example.wallpaperprogram

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.WallpaperManager
import android.widget.Button
import android.os.Handler
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var mywalllist:Array<Int> = arrayOf(R.drawable.wallpaper1,R.drawable.wallpaper2,R.drawable.wallpaper3,R.drawable.wallpaper4)
    private lateinit var changewallpaper: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changewallpaper = findViewById(R.id.button)
        changewallpaper.setOnClickListener { setWallpaper()}
    }

    fun setWallpaper() {
        Toast.makeText( this, "Setting Wallpaper", Toast.LENGTH_SHORT).show()
        Handler().postDelayed(
            {
                for (i in mywalllist){
                    val manager = WallpaperManager.getInstance(baseContext)
                    manager.setResource(i)
                    Thread.sleep(5000)
                }
            }
            ,3000)
    }
}
