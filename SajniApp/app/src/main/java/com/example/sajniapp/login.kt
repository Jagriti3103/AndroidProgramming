package com.example.sajniapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val signup = findViewById<TextView>(R.id.gotosignup)

        signup.setOnClickListener(){
            val intent = Intent(this,SignUp::class.java)
            startActivity(intent)
            finish()
        }
    }
}