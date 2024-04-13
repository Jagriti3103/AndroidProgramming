package com.example.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val listview= findViewById<ListView>(R.id.taskList)

        val tasklist = arrayListOf<String>()
        tasklist.add("Task 1")
        tasklist.add("Task 2")
        tasklist.add("Task 3")
        tasklist.add("Task 4")
        tasklist.add("Task 5")
        tasklist.add("Task 6")
        tasklist.add("Task 7")

        //adapter is used to save data for list view
        val adapterForListView = ArrayAdapter(this, android.R.layout.simple_list_item_1, tasklist)
        listview.adapter = adapterForListView

        listview.setOnItemClickListener { parent, view, position, id ->
            val text = "Clicked on : " + (view as TextView).text.toString()
            Toast.makeText(this, text,Toast.LENGTH_SHORT).show()
        }


    }
}