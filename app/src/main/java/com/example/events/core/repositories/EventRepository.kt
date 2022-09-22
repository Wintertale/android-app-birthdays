package com.example.events.core.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.events.core.db.AppDatabase
import com.example.events.core.models.EventEntity

class EventRepository(context :Context) {

    // TODO: Data Source concept can be integrated for Room DB as a data source

    private val eventDao = AppDatabase.getInstance(context).EventDao()

    suspend fun getAllEvents(): List<EventEntity> {
        return eventDao.getAllEvents()
    }

    suspend fun addEvent(event :EventEntity) {
        eventDao.insert(event)
    }
}