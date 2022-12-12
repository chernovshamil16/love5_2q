package com.example.love5_2.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.love5_2.love.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}