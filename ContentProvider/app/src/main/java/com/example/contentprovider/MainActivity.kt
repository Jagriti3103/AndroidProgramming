package com.example.contentprovider

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        const val KEY = "com.example.contentprovider.MainActivity.KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnOrder)
        val eT1 = findViewById<TextView>(R.id.eT1)
        val eT2 = findViewById<TextView>(R.id.eT2)
        val eT3 = findViewById<TextView>(R.id.eT3)
        val eT4 = findViewById<TextView>(R.id.et4) // Corrected id to et4

        btn.setOnClickListener {
            val ordersPlaced = "${eT1.text}, ${eT2.text}, ${eT3.text}, ${eT4.text}."
            val intent = Intent(this, Orders::class.java)
            intent.putExtra(KEY, ordersPlaced)
            startActivity(intent)
        }
    }
}
