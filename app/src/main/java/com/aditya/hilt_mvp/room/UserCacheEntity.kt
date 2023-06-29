package com.aditya.hilt_mvp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserCacheEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("id")
    val id: Int,

    @ColumnInfo("name")
    val name: String,

    @ColumnInfo("username")
    val userName: String,

    @ColumnInfo("gmail")
    val gmail: String
)