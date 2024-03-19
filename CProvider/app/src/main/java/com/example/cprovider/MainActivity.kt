package com.example.cprovider

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object{
        const val KEY = "com.example.cprovider.MainActivity.KEY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.button)
        val eT1 =findViewById<TextView>(R.id.eT1)
        val eT2 =findViewById<TextView>(R.id.eT2)
        val eT3 =findViewById<TextView>(R.id.eT3)
        val eT4 =findViewById<TextView>(R.id.eT4)

        btn.setOnClickListener(){
            val ordersPlaced= eT1.text.toString() + ", " + eT2.text.toString() + ", "+
                    eT3.text.toString() + ", " + eT4.text.toString()

            val intent= Intent(this, Orders::class.java)
            intent.putExtra(KEY, ordersPlaced)
            startActivity(intent)
        }
    }
}