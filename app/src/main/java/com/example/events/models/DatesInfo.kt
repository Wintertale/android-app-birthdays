package com.example.events.models

import java.time.LocalDate


class DatesInfo constructor(
    val id :Int,
    var eventDescription :String,
    var date: LocalDate,
    var eventType: EventType,
    var eventPriority : EventPriority
) {
}