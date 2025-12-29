package com.example.kotlin_practice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MP1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val count = 2 // Change this to the number of Fibonacci numbers you want to generate
        val fibonacciNumbers = generateFibonacci(count)
        Log.d("Midterm", "First $count Fibonacci numbers: $fibonacciNumbers")

    }

    fun generateFibonacci(n: Int): List<Int> {
        val seq = mutableListOf<Int>(0, 1)
        var i = n
        while (i > 2) {
            seq.add(seq[seq.size - 1] + seq[seq.size - 2])
            i--
        }
        return seq
    }
}
