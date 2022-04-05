package dev.vidaemcorrotinaapi.service

import dev.vidaemcorrotinaapi.dto.NewPost
import dev.vidaemcorrotinaapi.dto.UpdatePost
import dev.vidaemcorrotinaapi.entity.PostEntity
import dev.vidaemcorrotinaapi.mapper.toEntity
import dev.vidaemcorrotinaapi.repository.PostRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.Optional
import java.util.UUID

@Service
class PostService(val postRepository: PostRepository) {
    fun listAll(): MutableList<PostEntity> {
        return postRepository.findAll()
    }

    fun findById(id: String): PostEntity {
        return postRepository.findById(UUID.fromString(id)).get();
    }

    fun create(newPost: NewPost): PostEntity {
        return postRepository.save(newPost.toEntity())
    }

    fun update(id: String, updatedPost: UpdatePost): PostEntity {
        postRepository.findById(UUID.fromString(id)).get().let {
            it.title = updatedPost.title ?: it.title
            it.text = updatedPost.text ?: it.text
            it.active = updatedPost.active ?: it.active
            it.updatedAt = LocalDateTime.now()
            return postRepository.save(it)
        }
    }
}
