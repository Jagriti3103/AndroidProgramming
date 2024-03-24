package com.example.cprovider

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Orders : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_orders)
         val tVOrder = findViewById<TextView>(R.id.tVOrder)
        val ordersOfCustomer= intent.getStringExtra(MainActivity.KEY)
        tVOrder.text= "Order Placed are: " + ordersOfCustomer.toString()

        val change = findViewById<Button>(R.id.change)
        change.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
    }
    }
}