package com.example.listview2

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var userArrayList : ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val name = arrayOf("Aryan","Shravan","Ayushi","Riya","Akshita")
        val msg = arrayOf("Good Morning Dear!","Hello There!","Good","Congratulations","That is so Good to know")
        val msgtime = arrayOf("9:10 PM","8:43 PM","7:22 PM","5:00 PM","3:01 PM")
        val number = arrayOf("123456789","123456789","123456789","123456789","123456789")
        val imgid = arrayOf(R.drawable.pic4, R.drawable.pic1 ,R.drawable.pic2, R.drawable.pic0,R.drawable.pic3)

        userArrayList = ArrayList()
        for (EachIndex in name.indices){
            val user = User(name[EachIndex], msg[EachIndex], msgtime[EachIndex],number[EachIndex], imgid[EachIndex])

            userArrayList.add(user)
        }
        val ListView= findViewById<ListView>(R.id.lview)
        ListView.isClickable = true
        ListView.adapter = MyAdapter(this, userArrayList)

    }
}