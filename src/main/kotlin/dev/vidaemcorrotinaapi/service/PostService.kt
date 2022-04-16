package dev.vidaemcorrotinaapi.service

import dev.vidaemcorrotinaapi.dto.FullPost
import dev.vidaemcorrotinaapi.dto.NewPost
import dev.vidaemcorrotinaapi.dto.UpdatePost
import dev.vidaemcorrotinaapi.mapper.toEntity
import dev.vidaemcorrotinaapi.mapper.toFullPostDto
import dev.vidaemcorrotinaapi.repository.PostRepository
import dev.vidaemcorrotinaapi.repository.UserRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class PostService(
    val postRepository: PostRepository,
    val userRepository: UserRepository
) {
    fun listAll(active: Boolean): MutableList<FullPost> {
        return postRepository.findAllByActive(active).map { entity -> entity.toFullPostDto() }.toMutableList()
    }

    fun findById(id: String): FullPost {
        return postRepository.findById(UUID.fromString(id)).get().toFullPostDto()
    }

    fun create(newPost: NewPost): FullPost {
        val author = userRepository.findById(UUID.fromString(newPost.authorId!!))
        when {
            author.isPresent -> return postRepository.save(newPost.toEntity(author.get())).toFullPostDto()
            else -> throw IllegalArgumentException("authorId '${newPost.authorId}' does not exist")
        }
    }

    fun update(id: String, updatedPost: UpdatePost): FullPost {
        postRepository.findById(UUID.fromString(id)).get().let {
            it.title = updatedPost.title ?: it.title
            it.text = updatedPost.text ?: it.text
            it.active = updatedPost.active ?: it.active
            it.updatedAt = LocalDateTime.now()
            return postRepository.save(it).toFullPostDto()
        }
    }
}
