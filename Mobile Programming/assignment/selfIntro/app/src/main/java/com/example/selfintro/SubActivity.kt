package com.example.selfintro

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class SubActivity : AppCompatActivity() {
    // Portfolio screen: shows project cards and reveals details via dialogs.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        // Show details for project 1 in a modal dialog.
        findViewById<android.view.View>(R.id.card_project_1).setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.project_1_title))
                .setMessage(getString(R.string.project_1_detail))
                .setPositiveButton(R.string.action_close, null)
                .show()
        }
        // Show details for project 2 in a modal dialog.
        findViewById<android.view.View>(R.id.card_project_2).setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.project_2_title))
                .setMessage(getString(R.string.project_2_detail))
                .setPositiveButton(R.string.action_close, null)
                .show()
        }
        // Show details for project 3 in a modal dialog.
        findViewById<android.view.View>(R.id.card_project_3).setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.project_3_title))
                .setMessage(getString(R.string.project_3_detail))
                .setPositiveButton(R.string.action_close, null)
                .show()
        }
        // Return to the previous screen.
        findViewById<android.widget.Button>(R.id.btn_back).setOnClickListener {
            finish()
        }
    }
}


