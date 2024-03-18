package com.example.sajniapp

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sajniapp.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUp : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set view binding
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth= Firebase.auth
        binding.btnSignUp.setOnClickListener(){
            val email = binding.etemail.text.toString()
            val password =binding.etpassword.text.toString()
            if(checkAllField()){
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(){
                    //if successful account is created
                    //is also signed in
                    if(it.isSuccessful){
                        //can ignore
                        auth.signOut()
                        Toast.makeText(this,"Account Created Successfully!",Toast.LENGTH_LONG).show()
                    }
                    else{
                        Log.e("error", it.exception.toString())
                    }
                }
            }
        }
        
    }
    private fun checkAllField(): Boolean {
        val email = binding.etemail.text.toString()
        if(binding.etemail.text.toString() == ""){
            binding.textIpEmail.error = "This is required field"
            return false
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.textIpEmail.error = "Invalid email format"
            return false
        }
        //Password should be atleast 6 characters
        if(binding.etpassword.text.toString() == ""){
            binding.textIpPassword.error = "This is required field"
            binding.textIpPassword.errorIconDrawable = null
            return false
        }
        if(binding.etpassword.length() <= 6){
            binding.textIpPassword.error ="Password Should be atleast 8 characters"
            binding.textIpPassword.errorIconDrawable= null
            return false
        }
        if(binding.etconfirmpassword.text.toString() == ""){
            binding.textIpCPassword.error = "This is required field"
            binding.textIpCPassword.errorIconDrawable = null
            return false
        }
        if(binding.etpassword.text.toString() != binding.etconfirmpassword.text.toString()) {
            binding.textIpPassword.error = "Password Doesnot Match"
            return false
        }
        return true

    }
}
