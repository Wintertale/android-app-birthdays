package com.example.events.core.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.events.core.models.EventEntity

@Dao
interface EventDao {
    @Query("SELECT * FROM eventEntity ORDER BY month ASC")
    suspend fun getAllEvents(): List<EventEntity>

    @Query("SELECT * FROM eventEntity WHERE month = :targetMonth")
    suspend fun loadAllByMonth(targetMonth: Int): List<EventEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(event: EventEntity)

    @Delete
    suspend fun delete(event: EventEntity)
}