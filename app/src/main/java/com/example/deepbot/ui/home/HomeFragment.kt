package com.example.deepbot.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.deepbot.R
import com.example.deepbot.ui.games.GameFragment
import com.example.deepbot.ui.survey.SurveyFragment
import com.example.deepbot.ui.werabledata.WerableDataFragment
import com.example.deepbot.ui.gallery.GalleyFragment
// Import WearableDataFragment


class HomeFragment : Fragment() {
    private lateinit var viewModel: HomeViewModel
    private lateinit var rootView: View
    private lateinit var playNowButton: Button
    private lateinit var submitMoodButton: Button
    private lateinit var submitWearableDataButton: Button // New button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rootView = inflater.inflate(R.layout.fragment_home, container, false)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        val moodSlider = rootView.findViewById<SeekBar>(R.id.moodSlider)
        val emojiImageView = rootView.findViewById<ImageView>(R.id.emojiImageView)
        val quoteTextView = rootView.findViewById<TextView>(R.id.quoteTextView)
        val backgroundLayout = rootView.findViewById<LinearLayout>(R.id.mainContainer)
        playNowButton = rootView.findViewById(R.id.playNowButton)
        submitMoodButton = rootView.findViewById(R.id.submitMoodButton)
        submitWearableDataButton = rootView.findViewById(R.id.submitWearableData) // Find button

        // Observe mood changes
        viewModel.mood.observe(viewLifecycleOwner) { mood ->
            emojiImageView.setImageResource(viewModel.getEmojiForMood(mood))
            quoteTextView.text = viewModel.getQuoteForMood(mood)
            backgroundLayout.setBackgroundColor(
                ContextCompat.getColor(requireContext(), viewModel.getBackgroundColor(mood))
            )
        }

        // Mood Slider Change Listener
        moodSlider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                viewModel.updateMood(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Submit Mood Button → Navigates to SurveyFragment
        submitMoodButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SurveyFragment())
                .addToBackStack(null)
                .commit()
        }

        // Play Now Button → Navigates to GameFragment
        playNowButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, GameFragment())
                .addToBackStack(null)
                .commit()
        }

        // Submit Wearable Data Button → Navigates to WearableDataFragment
        submitWearableDataButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, WerableDataFragment())
                .addToBackStack(null)
                .commit()
        }



        return rootView
    }
}
