package com.example.intent_ex

import android.app.SearchManager
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/*
 * SubActivity
 * - Receives ACTION_WEB_SEARCH implicit intent with a query
 * - Displays the query on top and lets user input a multiline message
 * - Returns the user message (and original query) back to MainActivity
 */
class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        // Read and display the incoming search query
        val query = intent?.getStringExtra(SearchManager.QUERY).orEmpty()
        val textView: TextView = findViewById(R.id.tv_query)
        textView.text = query

        // Hook up Return button to send back the user's message via setResult
        val btnReturn: Button = findViewById(R.id.btn_return)
        val notesInput: EditText = findViewById(R.id.inputText)
        btnReturn.setOnClickListener {
            val result = intent.apply {
                putExtra(EXTRA_USER_MESSAGE, notesInput.text?.toString().orEmpty())
                putExtra(SearchManager.QUERY, query)
            }
            setResult(RESULT_OK, result)
            finish()
        }
    }

    // Intent extras keys exposed for other components
    companion object {
        const val EXTRA_USER_MESSAGE = "extra_user_message"
    }
}

