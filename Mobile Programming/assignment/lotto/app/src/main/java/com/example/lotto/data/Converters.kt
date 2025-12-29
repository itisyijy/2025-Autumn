package com.example.lotto.data

import androidx.room.TypeConverter

// convert List<Int> to String to use RoomDB
class Converters {
    // convert String to List<Int> when retrieving data
    // "7,12,23,31,38,42" → [7, 12, 23, 31, 38, 42]
    @TypeConverter // Room automtically uses this converter
    fun fromString(value: String): List<Int> {
        return if (value.isEmpty()) {
            emptyList()
        } else {
            value.split(",").map { it.toInt() }
        }
    }

    // convert List<Int> to String when storing data
    // [7, 12, 23, 31, 38, 42] → "7,12,23,31,38,42"
    @TypeConverter // Room automtically uses this converter
    fun toString(list: List<Int>): String {
        return list.joinToString(",")
    }
}

