package com.example.love5_2.room

import com.example.love5_2.model.LoveModel
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase :RoomDatabase() {
    abstract fun historyDao(): HistoryDao


}