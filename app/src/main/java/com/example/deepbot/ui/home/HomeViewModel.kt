package com.example.deepbot.ui.home

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.core.content.ContextCompat
import com.example.deepbot.R

class HomeViewModel : ViewModel() {

    private val _mood = MutableLiveData(2) // Default mood is Neutral
    val mood: LiveData<Int> get() = _mood

    fun updateMood(newMood: Int) {
        _mood.value = newMood
    }

    fun getEmojiForMood(moodIndex: Int): Int {
        return when (moodIndex) {
            0 -> R.drawable.ic_sad_emoji
            1 -> R.drawable.ic_angry_emoji
            2 -> R.drawable.ic_happy_emoji
            3 -> R.drawable.ic_happy_emoji
            4 -> R.drawable.ic_sad_emoji
            else -> R.drawable.ic_happy_emoji        }
    }

    fun getQuoteForMood(moodIndex: Int): String {
        return when (moodIndex) {
            0 -> "It's okay to feel sad. Every cloud has a silver lining."
            1 -> "Take a deep breath. Happiness is within you."
            2 -> "Stay calm and carry on."
            3 -> "Happiness is a choice, make it yours!"
            4 -> "Excitement fuels life. Enjoy the moment!"
            else -> "Embrace your feelings and move forward."
        }
    }

    fun getBackgroundColor(moodIndex: Int): Int {
        return when (moodIndex) {
            0 ->  R.color.name   // Sad
            1 ->  R.color.name // Angry
            2 ->  R.color.name  // Neutral
            3 ->  R.color.name  // Happy
            4 ->  R.color.name // Excited
            else -> R.color.name // Default (Neutral)
        }
    }
}
