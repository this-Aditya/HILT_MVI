package com.aditya.hilt_mvp.retrofit

import com.aditya.hilt_mvp.model.User
import com.aditya.hilt_mvp.utils.EntityMapper
import javax.inject.Inject

class NetworkEntityMapper @Inject constructor() : EntityMapper<UserNetworkEntity, User> {

    override fun mapFromEntity(entity: UserNetworkEntity): User =
        User(entity.id, entity.name, entity.username, entity.gmail)

    override fun mapToEntity(domainModel: User): UserNetworkEntity =
        UserNetworkEntity(domainModel.id, domainModel.name, domainModel.username, domainModel.gmail)

    fun mapFromEntityList(entities: List<UserNetworkEntity>): List<User> = entities.map{mapFromEntity(it)}

    fun mapToEntityList(users: List<User>): List<UserNetworkEntity> = users.map {mapToEntity(it)}

}