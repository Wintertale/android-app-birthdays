package com.example.events.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.events.models.DatesInfo
import com.example.events.models.EventPriority
import com.example.events.models.EventType
import java.time.LocalDate
import kotlin.collections.ArrayList


class MainEventsListViewModel : ViewModel() {

    private var datesInfoList: MutableLiveData<List<DatesInfo>> = MutableLiveData<List<DatesInfo>>()

    fun getDatesInfoList(): LiveData<List<DatesInfo>> {
        datesInfoList.value = loadUsers()

        return datesInfoList
    }

    private fun loadUsers() :List<DatesInfo> {
        // TODO: remove test data
        val datesArrayList = ArrayList<DatesInfo>()
        datesArrayList.add(DatesInfo(0, "Tuomas Holopainen", LocalDate.of(1976, 12, 25), EventType.BIRTHDAY, EventPriority.HIGH))
        datesArrayList.add(DatesInfo(1, "Tarja Turunen", LocalDate.of(1977, 8, 17), EventType.BIRTHDAY, EventPriority.HIGH))
        datesArrayList.add(DatesInfo(2, "Jukka Nevalainen", LocalDate.of(1978, 4, 21), EventType.BIRTHDAY, EventPriority.MIDDLE))
        datesArrayList.add(DatesInfo(3, "Emppu Vuorinen", LocalDate.of(1978, 6, 24), EventType.BIRTHDAY, EventPriority.HIGH))

        return datesArrayList

        // TODO:  Do an asynchronous operation to fetch users.
    }
}