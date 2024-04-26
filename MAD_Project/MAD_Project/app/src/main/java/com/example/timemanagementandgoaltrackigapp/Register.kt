package com.example.timemanagementandgoaltrackigapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Register : AppCompatActivity() {

    var indexglobal =0
    @SuppressLint("Range", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var helper = DBHelper(applicationContext)


        val usernameGet = findViewById<EditText>(R.id.edtUsername)
        var username = usernameGet.text.toString()
        val passwordGet = findViewById<EditText>(R.id.edtPassword)
        var password = passwordGet.text.toString()

        //val signInClick = findViewById<Button>(R.id.btnSignin)

        val signinBtn = findViewById<Button>(R.id.btnSigninRegister)

        signinBtn.setOnClickListener{
            var index = ++indexglobal
            helper.insertData(
                index!!,
                username!!,
                password!!
            )

            val bundle = Bundle()
            bundle.putString("username", username)
            val gotoNextScreen = Intent(applicationContext, Dashboard::class.java)
            gotoNextScreen.putExtras(bundle)
            startActivity(gotoNextScreen)
        }

    }
}