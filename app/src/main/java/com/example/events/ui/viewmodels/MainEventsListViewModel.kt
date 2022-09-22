package com.example.events.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.events.core.models.EventEntity
import com.example.events.core.models.EventPriority
import com.example.events.core.models.EventType
import com.example.events.core.repositories.EventRepository
import kotlinx.coroutines.launch

class MainEventsListViewModel(application: Application) : AndroidViewModel(application) {

    private var datesInfoList = MutableLiveData<List<EventEntity>>()
    private val eventRepository = EventRepository(getApplication())

    fun getDatesInfoList(): LiveData<List<EventEntity>> {
        viewModelScope.launch {
            datesInfoList.value = eventRepository.getAllEvents()
        }

        return datesInfoList
    }

    fun addTestEvents() {
        // TODO: remove test data
        val datesArrayList = ArrayList<EventEntity>()
        datesArrayList.add(EventEntity(0, "Tuomas Holopainen", 1976, 12, 25, EventType.BIRTHDAY, EventPriority.HIGH))
        datesArrayList.add(EventEntity(1, "Tarja Turunen", 1977, 8, 17, EventType.BIRTHDAY, EventPriority.HIGH))
        datesArrayList.add(EventEntity(2, "Jukka Nevalainen",1978, 4, 21, EventType.BIRTHDAY, EventPriority.MIDDLE))
        datesArrayList.add(EventEntity(3, "Emppu Vuorinen", 1978, 6, 24, EventType.BIRTHDAY, EventPriority.HIGH))

        for (event in datesArrayList) {
            addEventToDatabase(event)
        }
    }

    private fun addEventToDatabase(event :EventEntity) {
        viewModelScope.launch {
            eventRepository.addEvent(event)
        }
    }
}