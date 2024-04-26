package com.example.timemanagementandgoaltrackigapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity1 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val videoView : VideoView = findViewById<VideoView>(R.id.videoView)
        videoView.setOnCompletionListener {
            videoView.start()
        }
        videoView.setVideoPath("android.resource://" + packageName + "/" + R.raw.title)
        videoView.start()
    }

    fun goNextPage(view: View) {
        val i: Intent = Intent(this, MainActivity2::class.java)
        startActivity(i)
    }

}