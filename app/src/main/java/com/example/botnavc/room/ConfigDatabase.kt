package com.example.botnavc.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ConfigCacheEntity::class], version = 1)
abstract class ConfigDatabase: RoomDatabase() {
    abstract fun configDao(): ConfigDao
    companion object {
        val DATABASE_NAME: String = "config_db"
    }

}