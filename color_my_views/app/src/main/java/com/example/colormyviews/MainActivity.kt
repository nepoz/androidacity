package com.example.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setBoxListeners()
        setButtonListeners()
    }

    private fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun setBoxListeners() {
        val boxes = listOf<View>(
            findViewById(R.id.box_one_text),
            findViewById(R.id.box_two_text),
            findViewById(R.id.box_three_text),
            findViewById(R.id.box_four_text),
            findViewById(R.id.box_five_text),
            findViewById(R.id.root_constraint)
        )

        boxes.forEach {
            it.setOnClickListener { view -> makeColored(view) }
        }
    }

    private fun setButtonListeners() {
        val buttons = listOf<View>(
            findViewById(R.id.red_button),
            findViewById(R.id.yellow_button),
            findViewById(R.id.green_button)
        )

        buttons.forEach {
            it.setOnClickListener {view -> changeTextColor(view)}
        }
    }

    private fun changeTextColor(v: View) {
        when (v.id) {
            R.id.red_button -> findViewById<TextView>(R.id.box_three_text).setBackgroundColor(Color.RED)
            R.id.yellow_button ->findViewById<TextView>(R.id.box_four_text).setBackgroundColor(Color.YELLOW)
            R.id.green_button -> findViewById<TextView>(R.id.box_five_text).setBackgroundColor(Color.GREEN)
        }
    }


}