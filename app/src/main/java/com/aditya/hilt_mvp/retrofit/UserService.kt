package com.aditya.hilt_mvp.retrofit

import com.aditya.hilt_mvp.model.User
import retrofit2.http.GET

interface UserService {

    @GET("/users")
    suspend fun getUsers(): List<UserNetworkEntity>
}