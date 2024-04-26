package com.example.timemanagementandgoaltrackigapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnYoutube : ImageButton = findViewById(R.id.imageButton2)
        val btnFacebook : ImageButton = findViewById(R.id.imageButton3)
        val btnInsta : ImageButton = findViewById(R.id.imageButton4)
        val btnTiktok : ImageButton = findViewById(R.id.imageButton5)
        val btnSnapchat : ImageButton = findViewById(R.id.imageButton6)

        btnYoutube.setOnClickListener {
            moveToInternet("https://www.youtube.com/")
        }

        btnFacebook.setOnClickListener {
            moveToInternet("https://web.facebook.com/")
        }

        btnInsta.setOnClickListener {
            moveToInternet("https://www.instagram.com/")
        }

        btnTiktok.setOnClickListener {
            moveToInternet("https://www.tiktok.com/en/")
        }

        btnSnapchat.setOnClickListener {
            moveToInternet("https://www.snapchat.com/")
        }
    }

    fun moveToInternet(url : String){
        val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(i)
    }
}