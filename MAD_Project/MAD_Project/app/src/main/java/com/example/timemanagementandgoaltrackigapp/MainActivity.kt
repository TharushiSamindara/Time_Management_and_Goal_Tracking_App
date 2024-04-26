package com.example.timemanagementandgoaltrackigapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("Range", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var helper = DBHelper(applicationContext)

        //login part
        val btnLogIn = findViewById<Button>(R.id.btnLogin)
        val getUserName1 = findViewById<EditText>(R.id.edtUsername1)
        val getPassword1 = findViewById<EditText>(R.id.edtPassword1)

        ////////
        val tt11 = findViewById<TextView>(R.id.tt)
        val tt22 = findViewById<TextView>(R.id.tt2)



        val userNameEnter = getUserName1.text.toString()
        val passwordEnter = getPassword1.text.toString()

        val db = helper.readableDatabase
        val i = intent
        val bundle = Bundle()
        bundle.putString("userN", userNameEnter)

        /*btnLogIn.setOnClickListener{
            tt11.text = getUserName1.text
            tt22.text = passwordEnter
        }*/


        btnLogIn.setOnClickListener{
            val res2 = db.rawQuery("SELECT * FROM Users WHERE password ='$passwordEnter'",null)

            while(res2.moveToNext()) {
                val checkusername = res2.getString(res2.getColumnIndex("username"))
                if(getUserName1.toString().length != 0) {
                    if (getPassword1.toString().length != 0) {
                        if (checkusername.compareTo(userNameEnter) == 0) {
                            val gotoNextScreen = Intent(applicationContext, Dashboard::class.java)
                            gotoNextScreen.putExtras(bundle)
                            startActivity(gotoNextScreen)
                        } else {
                            Toast.makeText(
                                baseContext,
                                "Incorrect Password or username",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(baseContext, "Enter Password", Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(baseContext, "Enter Username", Toast.LENGTH_SHORT).show()
                }
            }



        }

        /*val i = intent
        val userNameCheck = getUserName.toString()
        val db = helper.readableDatabase
        val res = db.rawQuery("SELECT * FROM Users WHERE username ='$userNameCheck'",null)*/


        //Sign in part
        val btnnSignIn = findViewById<Button>(R.id.btnSignin)
        val content = SpannableString("Sign In")
        content.setSpan(UnderlineSpan(), 0, content.length, 0)
        btnnSignIn.text = content

        btnnSignIn.setOnClickListener{
            val gotoNextScreen = Intent(applicationContext,Register::class.java)
            startActivity(gotoNextScreen)
        }
    }
}