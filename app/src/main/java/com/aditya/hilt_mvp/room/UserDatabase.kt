package com.aditya.hilt_mvp.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserCacheEntity::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        const val DATABASE_NAME = "users_db"
    }
}