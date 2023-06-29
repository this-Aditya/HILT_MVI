package com.aditya.hilt_mvp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserUser(user: UserCacheEntity): Long

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<CacheEntityMapper>

}