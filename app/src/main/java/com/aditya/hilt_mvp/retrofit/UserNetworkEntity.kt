package com.aditya.hilt_mvp.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserNetworkEntity(
    @SerializedName("id")
    @Expose
    val id: Int ,

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("username")
    @Expose
    val username: String,

    @SerializedName("email")
    @Expose
    val gmail: String
)