package com.example.timemanagementandgoaltrackigapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val i = intent
        val userHead = i.getStringExtra("userN")

        val headUsername = findViewById<TextView>(R.id.txtUserName2)

        headUsername.text = userHead

        val relax = findViewById<Button>(R.id.btnRelaxation)
        relax.setOnClickListener{
            val gotoNextScreen = Intent(applicationContext,MainActivity1::class.java)
            startActivity(gotoNextScreen)
        }
    }
}