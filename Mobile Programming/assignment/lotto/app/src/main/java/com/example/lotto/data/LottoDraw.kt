package com.example.lotto.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lotto_draws")

// data class for each lotto draw
data class LottoDraw(
    @PrimaryKey(autoGenerate = true) // id as primary key with auto-increment
    val id: Long = 0, // draw id
    val numbers: List<Int> = emptyList(), // list of 6 numbers (1-45)
    val timestamp: Long = System.currentTimeMillis() // created time
)

