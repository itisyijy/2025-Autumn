package com.example.intent_ex

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar

/*
 * MainActivity
 * - Launches an implicit web search via chooser using the user's query
 * - Receives result when our app is chosen and SubActivity returns
 * - Shows the returned message as a Snackbar
 */
class MainActivity : AppCompatActivity() {
    // Activity Result launcher: handles results from the chooser (SubActivity returns a message)
    private val webSearchLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val msg = result.data?.getStringExtra(SubActivity.EXTRA_USER_MESSAGE).orEmpty()
            if (msg.isNotEmpty()) {
                val root = findViewById<android.view.View>(R.id.main)
                Snackbar.make(root, msg, Snackbar.LENGTH_LONG).show()
            }
        }
    }

    // UI setup and click wiring
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchInput: EditText = findViewById(R.id.searchText)
        val searchButton: Button = findViewById(R.id.searchButton)

        // On click: validate input, build ACTION_WEB_SEARCH, launch chooser via Activity Result API
        searchButton.setOnClickListener {
            val query = searchInput.text?.toString()?.trim().orEmpty()
            if (query.isEmpty()) {
                Toast.makeText(this, "Please enter a search term", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val webSearchIntent = Intent(Intent.ACTION_WEB_SEARCH).apply {
                putExtra(SearchManager.QUERY, query)
            }

            val chooser = Intent.createChooser(webSearchIntent, "Search with")
            webSearchLauncher.launch(chooser)
        }
    }
}