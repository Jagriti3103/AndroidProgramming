package com.example.contentprovider

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Orders : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders2)

        val tVOrders = findViewById<TextView>(R.id.tVOrders)

        // Retrieve the string extra from the intent
        val ordersPlaced = intent.getStringExtra(MainActivity.KEY)

        // Check if the extra is not null before using it
        if (ordersPlaced != null) {
            // Set the text of the TextView
            tVOrders.text = "Orders PLACED Is: $ordersPlaced"
        } else {
            // Handle the case where the extra is null
            tVOrders.text = "No orders placed"
        }
    }
}
