package com.aditya.hilt_mvp.di

import com.aditya.hilt_mvp.repository.MainRepository
import com.aditya.hilt_mvp.retrofit.NetworkEntityMapper
import com.aditya.hilt_mvp.retrofit.UserService
import com.aditya.hilt_mvp.room.CacheEntityMapper
import com.aditya.hilt_mvp.room.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(
        dao: UserDao, retrofit: UserService,
        cacherMapper: CacheEntityMapper, networkMapper: NetworkEntityMapper
    ): MainRepository = MainRepository(dao, retrofit, networkMapper, cacherMapper)
}