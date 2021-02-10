package com.example.botnavc.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ConfigDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(configEntity: ConfigCacheEntity): Long

    @Query("SELECT * FROM config")
    suspend fun get(): List<ConfigCacheEntity>
}