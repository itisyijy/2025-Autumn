package com.example.selfintro

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // Entry point for the profile screen. Sets layout and wires UI interactions.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Navigate to the portfolio screen when the "View Projects" button is tapped.
        findViewById<android.widget.Button>(R.id.btn_more).setOnClickListener {
            startActivity(Intent(this, SubActivity::class.java))
        }
    }
}