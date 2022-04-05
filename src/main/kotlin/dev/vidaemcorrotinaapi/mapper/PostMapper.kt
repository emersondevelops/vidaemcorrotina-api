package dev.vidaemcorrotinaapi.mapper

import dev.vidaemcorrotinaapi.dto.FullPost
import dev.vidaemcorrotinaapi.entity.PostEntity
import dev.vidaemcorrotinaapi.dto.NewPost

fun NewPost.toEntity(): PostEntity {
    return PostEntity(title = title!!, text = text!!)
}

fun PostEntity.toFullPostDto(): FullPost {
    return FullPost(id = id, title = title, text = text, createdAt = createdAt, updatedAt = updatedAt)
}
