package com.example.newproject

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var currentImage = 0
    lateinit var image : ImageView
    var names = arrayOf("Model 1","Model 2","Model 3","Model 4")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val prev = findViewById<ImageButton>(R.id.prevImage)
        val next = findViewById<ImageButton>(R.id.nextImage)
        val text = findViewById<TextView>(R.id.textView)
        image = findViewById(R.id.imageView)

        prev.setOnClickListener {
            val idcurrentImageString = "pic$currentImage"
            val idcurrentImageInt = this.resources.getIdentifier(idcurrentImageString, "drawable", packageName)
            image.setImageResource(idcurrentImageInt)
            image.alpha = 0f
            currentImage = (4 + currentImage - 1) % 4

            val idImagetoshowString = "pic$currentImage"
            val idImagetoshowInt = this.resources.getIdentifier(idImagetoshowString, "drawable", packageName)
            image.setImageResource(idImagetoshowInt)
            image.alpha = 1f
            text.text = names[currentImage]
        }

        next.setOnClickListener {
            val idcurrentImageString = "pic$currentImage"
            val idcurrentImageInt = this.resources.getIdentifier(idcurrentImageString, "drawable", packageName)
            image.setImageResource(idcurrentImageInt)
            image.alpha = 0f
            currentImage = (4 + currentImage + 1) % 4

            val idImagetoshowString = "pic$currentImage"
            val idImagetoshowInt = this.resources.getIdentifier(idImagetoshowString, "drawable", packageName)
            image.setImageResource(idImagetoshowInt)
            image.alpha = 1f
            text.text = names[currentImage]
        }
    }
}
