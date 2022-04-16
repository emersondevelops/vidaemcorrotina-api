package dev.vidaemcorrotinaapi.mapper

import dev.vidaemcorrotinaapi.dto.FullPost
import dev.vidaemcorrotinaapi.entity.PostEntity
import dev.vidaemcorrotinaapi.dto.NewPost
import dev.vidaemcorrotinaapi.entity.UserEntity

fun NewPost.toEntity(author: UserEntity): PostEntity {
    return PostEntity(title = title!!, text = text!!, author = author)
}

fun PostEntity.toFullPostDto(): FullPost {
    return FullPost(
        id = id,
        title = title,
        text = text,
        createdAt = createdAt,
        updatedAt = updatedAt,
        author = author.name
    )
}
