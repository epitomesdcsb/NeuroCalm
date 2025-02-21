package com.example.deepbot.ui.welcome3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.example.deepbot.ui.welcome2.WelcomeActivity2


import com.example.deepbot.R

class WelcomeActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_welcome3)

        val getStartedButton: Button = findViewById(R.id.nextButton)

        // When user clicks "Get Started", navigate to WelcomeActivity
        getStartedButton.setOnClickListener {
            val intent = Intent(this@WelcomeActivity3, WelcomeActivity2::class.java)
            startActivity(intent)
            finish() // Finish SplashScreenActivity so the user can't go back to it
        }
    }
}
