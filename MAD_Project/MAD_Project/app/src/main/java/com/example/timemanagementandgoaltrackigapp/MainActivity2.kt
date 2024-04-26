package com.example.timemanagementandgoaltrackigapp

import android.app.Dialog
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.net.URL

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSocial : Button = findViewById(R.id.btnSocial)
        val btnMovie : Button = findViewById(R.id.btnMovie)
        val btnBook : Button = findViewById(R.id.btnBook)
        val btnGame : Button = findViewById(R.id.btnGame)

        btnSocial.setOnClickListener {
            showDialog()
        }

        btnMovie.setOnClickListener {
            moveToInternet("https://www.netflix.com/lk/")
        }

        btnGame.setOnClickListener {
            moveToInternet("https://play.google.com")
        }

        btnBook.setOnClickListener {
            moveToInternet("https://chat.whatsapp.com/LGQxPVVroQNEh3aTZ7NiOW")
        }

    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.activity_main3)

        val btnYoutube : ImageButton = dialog.findViewById(R.id.imageButton2)
        val btnFacebook : ImageButton = dialog.findViewById(R.id.imageButton3)
        val btnInsta : ImageButton = dialog.findViewById(R.id.imageButton4)
        val btnTiktok : ImageButton = dialog.findViewById(R.id.imageButton5)
        val btnSnapchat : ImageButton = dialog.findViewById(R.id.imageButton6)

        dialog.show()
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.window?.setGravity(Gravity.BOTTOM)

        btnYoutube.setOnClickListener {
            dialog.dismiss()
            moveToInternet("https://www.youtube.com/")
        }
        btnFacebook.setOnClickListener {
            dialog.dismiss()
            moveToInternet("https://web.facebook.com/")
        }

        btnInsta.setOnClickListener {
            dialog.dismiss()
            moveToInternet("https://www.instagram.com/")
        }

        btnTiktok.setOnClickListener {
            dialog.dismiss()
            moveToInternet("https://www.tiktok.com/en/")
        }

        btnSnapchat.setOnClickListener {
            dialog.dismiss()
            moveToInternet("https://www.snapchat.com/")
        }

    }

    fun moveToHome(view: View) {
        val i: Intent = Intent(this, Dashboard::class.java)
        startActivity(i)
    }

    private fun moveToInternet(url : String){
        val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(i)
    }
}