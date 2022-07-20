package com.example.composeplayground.data.models

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TodoTask::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun toDoDao(): TodoDao

}