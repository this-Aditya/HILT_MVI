package com.aditya.hilt_mvp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aditya.hilt_mvp.room.UserCacheEntity
import com.aditya.hilt_mvp.room.UserDao
import com.aditya.hilt_mvp.room.UserDatabase
import com.aditya.hilt_mvp.room.UserDatabase.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun provideUserDB(context: Context): UserDatabase =
        Room.databaseBuilder(context, UserDatabase::class.java, DATABASE_NAME)
            .build()

    @Provides
    @Singleton
    fun provideUserDao(userDatabase: UserDatabase): UserDao = userDatabase.userDao()


}