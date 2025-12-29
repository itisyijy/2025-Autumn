package com.example.kotlin_practice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MP2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = "the quick brown fox jumps over the lazy dog the fox"
        //val input = "jinjin woo woo jin wooo ya"
        //val input = "kotlin is android and or nand nor what"
        findFrequentWord(input)
    }

    fun findFrequentWord(str: String) {
        val allWords = str.split(" ")
        val frequency = mutableListOf<Int>()
        for (word in allWords) {
            frequency.add(allWords.count { it == word})
        }
        val maxFrequency = frequency.max()
        Log.d("Midterm", "Given the string $str")
        Log.d("Midterm", "Most frequent word: \"${allWords[frequency.indexOf(maxFrequency)]}\" " +
                "(appears ${frequency.max()} times)")
    }
}
