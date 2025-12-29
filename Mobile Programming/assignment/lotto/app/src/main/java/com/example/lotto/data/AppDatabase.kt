package com.example.lotto.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [LottoDraw::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class) // available Converter methods
abstract class AppDatabase : RoomDatabase() {
    // method to return DAO
    abstract fun lottoDrawDao(): LottoDrawDao
    
    companion object {
        // DB INSTANCE
        @Volatile
        private var INSTANCE: AppDatabase? = null
        
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) { // no concurrency
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "lotto_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

