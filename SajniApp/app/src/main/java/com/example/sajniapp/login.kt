package com.example.sajniapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.sajniapp.HomePage
import com.example.sajniapp.R
import com.example.sajniapp.SignUp
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        firebaseAuth = FirebaseAuth.getInstance()
        sharedPreferences = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE)

        val emailEditText = findViewById<TextInputEditText>(R.id.email)
        val passwordEditText = findViewById<TextInputEditText>(R.id.password)
        val rememberMeCheckBox = findViewById<CheckBox>(R.id.rememberMeCheckBox)
        val signup = findViewById<TextView>(R.id.gotosignup)
        val login = findViewById<TextView>(R.id.Login)

        signup.setOnClickListener {
            val intentSignUp = Intent(this, SignUp::class.java)
            startActivity(intentSignUp)
            finish()
        }

        login.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Sign in with email and password
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success
                        if (rememberMeCheckBox.isChecked) {
                            // Save email and password to SharedPreferences if "Remember Me" is checked
                            saveLoginCredentials(email, password)
                        }
                        // Navigate to HomePage
                        val intent = Intent(this, HomePage::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }

        // Retrieve and pre-fill saved email and password if "Remember Me" was checked previously
        if (sharedPreferences.getBoolean("rememberMe", false)) {
            emailEditText.setText(sharedPreferences.getString("email", ""))
            passwordEditText.setText(sharedPreferences.getString("password", ""))
            rememberMeCheckBox.isChecked = true
        }
    }

    private fun saveLoginCredentials(email: String, password: String) {
        val editor = sharedPreferences.edit()
        editor.putString("email", email)
        editor.putString("password", password)
        editor.putBoolean("rememberMe", true)
        editor.apply()
    }
}
