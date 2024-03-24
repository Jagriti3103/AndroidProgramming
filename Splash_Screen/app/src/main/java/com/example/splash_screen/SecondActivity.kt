package com.example.splash_screen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)

        btn1.setOnClickListener(){
            val intent = Intent(this,Linkedin::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener(){
            val intent = Intent(this,Github::class.java)
            startActivity(intent)
        }
        btn3.setOnClickListener(){
            val intent = Intent(this,Instagram::class.java)
            startActivity(intent)
        }

    }
    }