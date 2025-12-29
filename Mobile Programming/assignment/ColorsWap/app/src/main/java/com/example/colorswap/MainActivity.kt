package com.example.colorswap

import android.os.Bundle
import android.graphics.Color
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // View references
        val colorText = findViewById<TextView>(R.id.colorText)
        val colorButton = findViewById<Button>(R.id.colorButton)

        // Disable automatic view state restore for this TextView (do not keep last run text)
        colorText.isSaveEnabled = false

        // Set initial text and color on each cold start
        colorText.text = "Tap to Change Color"
        colorText.setTextColor(Color.BLACK)

        // Generate a random RGB color and apply it to the TextView
        // Also update the label: "COLOR: 195r 30g 110b"
        fun setRandomTextColor() {
            val r = Random.nextInt(0, 256)
            val g = Random.nextInt(0, 256)
            val b = Random.nextInt(0, 256)
            val color = Color.rgb(r, g, b)
            colorText.setTextColor(color)
            colorText.text = "COLOR: ${r}r ${g}g ${b}b"
        }

        // Change to a new random text color on each button click
        colorButton.setOnClickListener {
            setRandomTextColor()
        }
    }
}