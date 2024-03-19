package com.example.mapslogin

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.auth.User

class MainActivity : AppCompatActivity() {

    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loginbtn = findViewById<Button>(R.id.loginbtn)
        val username = findViewById<TextInputEditText>(R.id.etUsername)
        val email = findViewById<TextInputEditText>(R.id.etemail)
        val pwd = findViewById<TextInputEditText>(R.id.etpassword)

        loginbtn.setOnClickListener(){
            val username = username.text.toString()
            val email = email.text.toString()
            val pwd= pwd.text.toString()

            val user = Users(username,email,pwd)
            database= FirebaseDatabase.getInstance().getReference("Users")
            database.child(username).setValue(user).addOnSuccessListener {
                Toast.makeText(this,"User Registered",Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }
        }

    }
}