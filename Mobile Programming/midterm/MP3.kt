package com.example.kotlin_practice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MP3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createMatrix()
    }

    fun createMatrix() {
        val numRows = (2..5).random()
        val numCols = (2..5).random()
        Log.d("Midterm", "(${numRows}x${numCols}):")

        val matrix = mutableListOf<MutableList<Int>>()
        var totalSum = 0
        for (r in 0 until numRows) {
            val row = mutableListOf<Int>()
            for (c in 0 until numCols) {
                val elem = (10..99).random()
                row.add(elem)
                totalSum += elem
            }
            matrix.add(row)
            Log.d("Midterm", row.toString())
        }
        val average = totalSum.toFloat() / (numRows * numCols).toFloat()

        val colSum = IntArray(numCols)
        for (c in 0 until numCols) {
            var sum = 0
            for (r in 0 until numRows) {
                sum += matrix[r][c]
            }
            colSum[c] = sum
        }
        Log.d("Midterm", "Total sum: $totalSum")
        Log.d("Midterm", "Average: ${String.format("%.2f", average)}")
        Log.d("Midterm", "Column with highest sum: ${colSum.indexOf(colSum.max())} (sum: ${colSum.max()})")
    }
}
