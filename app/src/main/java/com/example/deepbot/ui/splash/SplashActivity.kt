package com.example.deepbot.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.example.deepbot.ui.welcome.WelcomeActivity
import com.example.deepbot.R

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val getStartedButton: Button = findViewById(R.id.startButton)

        // When user clicks "Get Started", navigate to WelcomeActivity
        getStartedButton.setOnClickListener {
            val intent = Intent(this@SplashScreenActivity, WelcomeActivity::class.java)
            startActivity(intent)
            finish() // Finish SplashScreenActivity so the user can't go back to it
        }
    }
}
