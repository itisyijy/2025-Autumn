package com.example.demoapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num = 5
        Log.d("Q01", "Z pattern for number: $num")
        val array = IntArray(num) { it + 1 }

        for (i in num downTo 1) {
            if (i == 1 || i == num) {
                // entire line
                printAll(array)
            } else {
                // partial
                printPart(i, num)
            }
        }
    }

    fun printAll(array: IntArray) {
        var str = ""
        for (i in 0..array.size - 1) {
            str += "${array[i]} "
        }
        Log.d("Q01", str)
    }

    fun printPart(i: Int, size: Int) {
        var str = ""
        for (j in 1..size) {
            if (i == j) {
                str += "$i "
            } else {
                str += "  "
            }
        }
        Log.d("Q01", str)
    }
}

