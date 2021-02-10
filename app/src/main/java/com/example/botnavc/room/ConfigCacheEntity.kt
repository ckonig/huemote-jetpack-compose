package com.example.botnavc.room

import androidx.room.ColumnInfo
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "config")
data class ConfigCacheEntity(

    @ColumnInfo(name = "ipaddress")
    val ipaddress: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "model")
    val model: String,

    @ColumnInfo(name = "localtime")
    val localtime: String,

    @ColumnInfo(name = "timezone")
    val timezone: String,

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "mac")
    val mac: String
) {
}