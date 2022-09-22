package com.example.events.core.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate


@Entity
data class EventEntity constructor(
    @PrimaryKey val id :Int,
    @ColumnInfo var description :String,
    @ColumnInfo var year :Int,
    @ColumnInfo var month :Int,
    @ColumnInfo var day :Int,
    @ColumnInfo var type : EventType,
    @ColumnInfo var priority : EventPriority
) {

    init {
        // If exception is thrown then the entered day/month/year are not valid
        LocalDate.of(year, month, day)
    }

    fun getDate(): LocalDate = LocalDate.of(year, month, day)
}