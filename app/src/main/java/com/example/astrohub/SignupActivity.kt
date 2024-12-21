package com.example.astrohub

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.astrohub.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.signupButton.setOnClickListener {
            val name = binding.signupName.text.toString()
            val username = binding.signupUsername.text.toString()
            val email = binding.signupEmail.text.toString()
            val password = binding.signupPassword.text.toString()
            val confirmPassword = binding.signupConfirm.text.toString()


            if(name.isNotEmpty() && username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()){
                if (password == confirmPassword){
                    registerUser(name, username, email, password)
                }else{
                    Toast.makeText(this,"Password & Confirm Password do not match", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"All fields are required", Toast.LENGTH_SHORT).show()
            }
        }
        //Explicit Intent
        binding.loginRedirect.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
    private fun registerUser(name: String, username: String, email: String, password: String){
        database = FirebaseDatabase.getInstance().getReference("Users")
        val user = User(name, username, email, password)
        database.child(username).setValue(user).addOnSuccessListener{
            binding.signupName.text?.clear()
            binding.signupUsername.text?.clear()
            binding.signupEmail.text?.clear()
            binding.signupPassword.text?.clear()
            binding.signupConfirm.text?.clear()
            Toast.makeText(this,"User Successfully Registered", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()
        }
    }
}