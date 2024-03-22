package com.example.mapslogin

<<<<<<< HEAD
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
=======
import android.os.Bundle
import android.widget.Button
>>>>>>> 2e270ec7b9c5331dac69b1d67fb58bbdab459960
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
<<<<<<< HEAD
        val Signupbtn = findViewById<Button>(R.id.Signupbtn)
        val username = findViewById<TextInputEditText>(R.id.etUsername)
        val email = findViewById<TextInputEditText>(R.id.etemail)
        val pwd = findViewById<TextInputEditText>(R.id.etpassword)
        val signintxt = findViewById<TextView>(R.id.Sigintext)

        signintxt.setOnClickListener(){
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }

        Signupbtn.setOnClickListener(){
=======
        val loginbtn = findViewById<Button>(R.id.loginbtn)
        val username = findViewById<TextInputEditText>(R.id.etUsername)
        val email = findViewById<TextInputEditText>(R.id.etemail)
        val pwd = findViewById<TextInputEditText>(R.id.etpassword)

        loginbtn.setOnClickListener(){
>>>>>>> 2e270ec7b9c5331dac69b1d67fb58bbdab459960
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