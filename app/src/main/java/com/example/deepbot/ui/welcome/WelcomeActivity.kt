package com.example.deepbot.ui.welcome

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

import com.example.deepbot.ui.welcome3.WelcomeActivity3
import com.example.deepbot.R

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_welcome)

        val getStartedButton: Button = findViewById(R.id.nextButton)

        // When user clicks "Get Started", navigate to WelcomeActivity
        getStartedButton.setOnClickListener {
            val intent = Intent(this@WelcomeActivity, WelcomeActivity3::class.java)
            startActivity(intent)
            finish() // Finish SplashScreenActivity so the user can't go back to it
        }
    }
}
