package dev.vidaemcorrotinaapi.mapper

import dev.vidaemcorrotinaapi.dto.NewUser
import dev.vidaemcorrotinaapi.dto.UserInfos
import dev.vidaemcorrotinaapi.entity.UserEntity

fun NewUser.toEntity(): UserEntity {
    return UserEntity(
        name = name!!,
        email = email!!,
        role = role!!,
        password = password!!
    )
}

fun UserEntity.toUserInfosDto(): UserInfos {
    return UserInfos(
        id = id,
        name = name,
        email = email,
        role = role,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}
