package com.example.splash_screen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        Handler().postDelayed({
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
            finish()
        },2000)
        }
    }