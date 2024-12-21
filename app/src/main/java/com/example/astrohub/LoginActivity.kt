package com.example.astrohub

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.astrohub.databinding.ActivityLoginBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    lateinit var database : DatabaseReference

    //use for passing data in WelcomeActivity.kt file
    companion object{
        const val KEY_NAME = "com.example.astrohub.LoginActivity.StoredUsername"
        const val KEY_UNAME = "com.example.astrohub.LoginActivity.StoredName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.loginButton.setOnClickListener{
            val username = binding.loginUsername.text.toString()
            val email = binding.loginEmail.text.toString()
            val password = binding.loginPassword.text.toString()

            if(username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()){
                readDatabase(username, email, password)
            }else{
                Toast.makeText(this,"All fields are required", Toast.LENGTH_SHORT).show()
            }
        }

        //Explicit Intent
        binding.signupRedirect.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }
    private fun readDatabase(username: String, email: String, password: String){
        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(username).get().addOnSuccessListener { snapshot ->
            if (snapshot.exists()) {
                val StoredUsername = snapshot.child("username").value?.toString()?.trim()
                val StoredName = snapshot.child("name").value?.toString()
                val StoredEmail = snapshot.child("email").value?.toString()?.trim()
                val StoredPassword = snapshot.child("password").value?.toString()?.trim()

                if (email != StoredEmail) {
                    Toast.makeText(this, "Incorrect email. Please try again.", Toast.LENGTH_SHORT).show()
                } else if (password != StoredPassword) {
                    Toast.makeText(this, "Incorrect password. Please try again.", Toast.LENGTH_SHORT).show()
                } else {
                    //Provide data to WelcomeActivity
                    val intent = Intent(this, WelcomeActivity::class.java)
                    intent.putExtra(KEY_NAME, StoredName)
                    intent.putExtra(KEY_UNAME, StoredUsername)
                    startActivity(intent)
                }

            }else{
                Toast.makeText(this, "User not found, please sign up first", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this, "Failed to retrieve data from the database", Toast.LENGTH_SHORT).show()
        }
    }
}