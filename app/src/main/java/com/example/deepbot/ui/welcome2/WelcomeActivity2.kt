package com.example.deepbot.ui.welcome2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.example.deepbot.MainActivity
import com.example.deepbot.R

class WelcomeActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_welcome2)

        val nextButton: Button = findViewById(R.id.nextButton)

        // On "Next" button click, navigate to MainActivity
        nextButton.setOnClickListener {
            val intent = Intent(this@WelcomeActivity2, MainActivity::class.java)
            startActivity(intent)
            finish() // Finish WelcomeActivity to prevent back navigation
        }
    }
}
