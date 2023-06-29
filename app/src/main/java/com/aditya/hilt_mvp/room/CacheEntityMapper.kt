package com.aditya.hilt_mvp.room

import com.aditya.hilt_mvp.model.User
import com.aditya.hilt_mvp.utils.EntityMapper
import javax.inject.Inject

class CacheEntityMapper @Inject constructor() : EntityMapper<UserCacheEntity, User> {

    override fun mapFromEntity(entity: UserCacheEntity): User =
        User(entity.id, entity.name, entity.userName, entity.gmail)

    override fun mapToEntity(domainModel: User): UserCacheEntity =
        UserCacheEntity(domainModel.id, domainModel.name, domainModel.username, domainModel.gmail)

    fun  mapFromEntities(entities: List<UserCacheEntity>): List<User> =
        entities.map { mapFromEntity(it) }

    fun mapToEntities(users: List<User>): List<UserCacheEntity> =
        users.map { mapToEntity(it) }
}