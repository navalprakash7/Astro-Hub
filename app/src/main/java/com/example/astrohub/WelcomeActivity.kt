package com.example.astrohub

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.astrohub.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve data from intent with null safety
        val name = intent.getStringExtra(LoginActivity.KEY_NAME) ?: "Guest"
        val username = intent.getStringExtra(LoginActivity.KEY_UNAME) ?: "N/A"

        // Set the text dynamically
        binding.textView1.text = "Welcome $name"
        binding.textView2.text = "Your username: $username"

        //Explicit Intent
        binding.button1.setOnClickListener{
            startActivity(Intent(this,SsystemActivity::class.java))
        }
        binding.button2.setOnClickListener{
            startActivity(Intent(this,GalaxyActivity::class.java))
        }
        binding.button3.setOnClickListener{
            startActivity(Intent(this,NebulaActivity::class.java))
        }
        binding.button4.setOnClickListener{
            startActivity(Intent(this,CelestialActivity::class.java))
        }
    }
}