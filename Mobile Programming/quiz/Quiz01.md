# 1. Write a Kotlin program that generates a number-Z pattern based on the given number. (50pts)
-	Assume we only use the number >= 3
-	Use basic loops (for, while, etc.)
-	No hard-coded solutions are allowed

```kotlin
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

```
```log

```

# 2. Write a Kotlin program that can identify and print prime numbers from the given list of integers (50pts).
-	Define “isPrime” function: Write a function called isPrime that takes an Int and returns a Boolean. This function should correctly identify if the given number is prime. 
-	Generate a list: Create a list of 10 random integers, with each number ranging from 1 to 100.
-	Filter the list: Use the filter function to process the list you generated. For filtering, use isPrime function you defined. 
-	Print the result: Print both the original list and the new list containing only the prime numbers.

```kotlin
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

```
```log

```