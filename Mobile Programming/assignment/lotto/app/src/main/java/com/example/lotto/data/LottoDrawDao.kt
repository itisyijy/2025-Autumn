package com.example.lotto.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

// Data Access Object, Define how to access the database
@Dao
interface LottoDrawDao { // declare methods to interact with the database
    // retrieve all draws in descending order of timestamp
    @Query("SELECT * FROM lotto_draws ORDER BY timestamp DESC")
    suspend fun getAllDraws(): List<LottoDraw>

    // create new draw
    @Insert
    suspend fun insertDraw(draw: LottoDraw): Long

    // delete draw
    @Delete
    suspend fun deleteDraw(draw: LottoDraw)

    // search draw by id
    @Query("SELECT * FROM lotto_draws WHERE id = :id")
    suspend fun getDrawById(id: Long): LottoDraw?
}

