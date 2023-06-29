package com.aditya.hilt_mvp.repository

import com.aditya.hilt_mvp.model.User
import com.aditya.hilt_mvp.retrofit.NetworkEntityMapper
import com.aditya.hilt_mvp.retrofit.UserNetworkEntity
import com.aditya.hilt_mvp.retrofit.UserService
import com.aditya.hilt_mvp.room.CacheEntityMapper
import com.aditya.hilt_mvp.room.UserCacheEntity
import com.aditya.hilt_mvp.room.UserDao
import com.aditya.hilt_mvp.utils.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import java.lang.Error
import java.lang.Exception
import java.util.concurrent.Flow
import javax.inject.Inject

class MainRepository
constructor(
    private val userDao: UserDao,
    private val retrofit: UserService,
    private val networkMapper: NetworkEntityMapper,
    private val cacheMapper: CacheEntityMapper
)
{
    suspend fun getUsers() = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val networkUsers: List<UserNetworkEntity> = retrofit.getUsers()
            val users: List<User> = networkMapper.mapFromEntityList(networkUsers)
            val cacheUsers: List<UserCacheEntity> = cacheMapper.mapToEntities(users)
            emit(DataState.Success(users))
        } catch (ex: Exception) {
            emit(DataState.Error(ex))
        }
    }
}