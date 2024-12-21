package com.example.astrohub

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        // Show splash screen content for 2 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            // Transition to the actual main screen (e.g., DashboardActivity)
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Prevent returning to this splash screen
        }, 2000) // 2000ms = 2 seconds
    }
}
