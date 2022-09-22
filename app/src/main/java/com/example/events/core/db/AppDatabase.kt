package com.example.events.core.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.events.core.db.dao.EventDao
import com.example.events.core.models.EventEntity

@Database(entities = [EventEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun EventDao(): EventDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase {
            var instance = INSTANCE

            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, AppDatabase::class.java.simpleName)
                    .build()
                INSTANCE = instance
            }

            return instance
        }
    }
}