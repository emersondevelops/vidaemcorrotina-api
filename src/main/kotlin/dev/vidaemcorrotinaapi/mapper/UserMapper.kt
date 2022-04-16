package dev.vidaemcorrotinaapi.mapper

import dev.vidaemcorrotinaapi.dto.NewUser
import dev.vidaemcorrotinaapi.entity.UserEntity

fun NewUser.toEntity(): UserEntity {
    return UserEntity(
        name = name!!,
        email = email!!,
        role = role!!,
        password = password!!
    )
}