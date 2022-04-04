package dev.vidaemcorrotinaapi.mapper

import dev.vidaemcorrotinaapi.entity.PostEntity
import dev.vidaemcorrotinaapi.dto.NewPost

fun NewPost.toEntity(): PostEntity {
    return PostEntity(title = title!!, text = text!!)
}
