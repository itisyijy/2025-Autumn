package com.example.demoapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fun isPrime(num: Int): Boolean {
            if (num <= 1)
                return false
            for (i in 2..num - 1) {
                if (num % i == 0)
                    return false
            }
            return true
        }

        val numbers = mutableListOf<Int>() // Generate a list
        for (i in 1..10) {
            numbers.add(nextInt(1, 101))
        }
        Log.d("Q01", "Original List: $numbers") // Print the original list

        val primeNumbers = numbers.filter { isPrime(it) } // Filter the list

        Log.d("Q01", "Prime Numbers: $primeNumbers") // Print the prime number list
    }

}

