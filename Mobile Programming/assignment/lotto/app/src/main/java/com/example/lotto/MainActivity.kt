package com.example.lotto

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lotto.adapter.LottoDrawAdapter
import com.example.lotto.data.AppDatabase
import com.example.lotto.data.LottoDraw
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LottoDrawAdapter
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        database = AppDatabase.getDatabase(this) // Initialize the database
        setupRecyclerView() // Initialize the RecyclerView
        setupGenerateButton() // Initialize the Generate button
        loadInitialData() // Load initial data from the database
    }

    // Initialize the RecyclerView
    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)
        // delete button click event
        adapter = LottoDrawAdapter { draw ->
            deleteDraw(draw)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    // Initialize the Generate button
    private fun setupGenerateButton() {
        // call generateLottoNumbers() when button is clicked
        findViewById<android.widget.Button>(R.id.generateButton).setOnClickListener {
            generateLottoNumbers()
        }
    }

    // Load initial data from the database
    private fun loadInitialData() {
        // Coroutine to load data from the database
        lifecycleScope.launch {
            val draws = database.lottoDrawDao().getAllDraws() // retrieve all draws
            adapter.setDraws(draws) // update adapter with data
        }
    }

    // Generate and insert a new lotto draw
    private fun generateLottoNumbers() {
        lifecycleScope.launch {
            val numbers = (1..45).shuffled().take(6) // random 6 number [1,45]
            val draw = LottoDraw(numbers = numbers) // generate LottoDraw object
            val insertedId = database.lottoDrawDao().insertDraw(draw) // add to database and get id

            // retrieve inserted draw from database and show in RecyclerView on top.
            val insertedDraw = database.lottoDrawDao().getDrawById(insertedId)
            insertedDraw?.let {
                adapter.addDraw(it, 0)
                recyclerView.smoothScrollToPosition(0)
            }
        }
    }

    // Delete a specific draw
    private fun deleteDraw(draw: LottoDraw) {
        lifecycleScope.launch {
            // find position of certain draw in adapter
            val position = (0 until adapter.itemCount).indexOfFirst { position ->
                adapter.getItem(position).id == draw.id
            }

            // remove from database and adapter
            if (position != -1) {
                database.lottoDrawDao().deleteDraw(draw)
                adapter.removeDraw(position)
            }
        }
    }
}
