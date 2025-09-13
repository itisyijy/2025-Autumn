package com.example.demoapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("HW01", "factorial(6) by loop = ${factorialLoop(6)}")
        Log.d("HW01", "factorial(6) by recursion = ${factorialLoop(6)}")
        Log.d("HW01", "factorial(8) by loop = ${factorialLoop(8)}")
        Log.d("HW01", "factorial(8) by recursion = ${factorialLoop(8)}")
        Log.d("HW01", "factorial(12) by loop = ${factorialLoop(12)}")
        Log.d("HW01", "factorial(12) by recursion = ${factorialLoop(12)}")
    }

    fun factorialLoop(n: Int): Int {
        var i = 1
        var answer = 1;
        while (i <= n) {
            answer *= i
            i++
        }
        return answer
    }

    fun factorialRecursion(n: Int): Int {
        if (n <= 1)
            return 1
        return n * factorialRecursion(n - 1)
    }

    fun palindromeDetector(str: String) {
        val lowercasedStr = str.lowercase() // case insensitive
        val reversedStr = lowercasedStr.reversed() // reversed order

        if (lowercasedStr == reversedStr) { // equal or not
            Log.d("HW01", "$str is a palindrome!")
        } else {
            Log.d("HW01", "$str is not a palindrome!")
        }
    }

    fun stringRotator(str: String) {
        val len = str.length
        var startPoint = 0;

        while (startPoint <= str.length) {
            var pre = str.substring(startPoint) // 1st part of string [startpoint,end]
            var post = str.substring(0, startPoint) // 2nd part of string [0,startpoint)
            Log.d("HW01", "$pre$post")
            startPoint++ // moving starting index of string
        }
    }

    fun vowelsCounter(line: String) {
        val vowels = setOf(65, 69, 73, 79, 85) // set of vowels
        var vowelsCount = 0
        var consonantsCount = 0
        var i = 0;

        while (i < line.length) {
            val ch = line.uppercase()[i].code // convert uppercased char to integer
            if (ch >= 65 && ch <= 90) { // range of A-Z ascii
                if (vowels.contains(ch)) // case: vowel
                    vowelsCount++
                else // case: consonants
                    consonantsCount++
            }
            i++
        }
        Log.d(
            "HW01", "\"$line\" -> vowels: $vowelsCount, " +
                    "consonants: $consonantsCount"
        )
    }

    // generate integer array with no repeat
    fun generateUniqueArray(capacity: Int) {
        val uniqueArray = IntArray(capacity) // initialize int array have size of capacity
        val numSet = mutableSetOf<Int>() // initialize set for making non-duplicate collection
        val random = Random()
        var index = 0;

        while (index < capacity) {
            var tmp = random.nextInt(100) + 1 // random int 1..100
            while (!numSet.add(tmp)) { // validate duplication
                tmp = random.nextInt(100) + 1 // false: recreate random number
            }
            uniqueArray[index] = tmp // set value
            index++
        }
        val myUniqueArray = uniqueArray.contentToString() // convert to String
        Log.d("HW01", "result: $myUniqueArray, capacity: $capacity")
    }

    // Define function to find max value between parameters
    fun max(a: Int, b: Int, c: Int) {
        val maxVal: Int // value for storing max value
        when {
            (a >= b && a >= c) -> maxVal = a    // if a is the largest
            (b >= a && b >= c) -> maxVal = b    // if b is the largest
            else -> maxVal = c                  // if c is the largest
        }

        // print out the result
        Log.d("HW01", "Max of ($a, $b, $c) = $maxVal")
    }
}

