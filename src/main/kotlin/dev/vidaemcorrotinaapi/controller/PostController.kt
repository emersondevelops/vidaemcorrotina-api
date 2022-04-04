package dev.vidaemcorrotinaapi.controller

import dev.vidaemcorrotinaapi.entity.PostEntity
import dev.vidaemcorrotinaapi.repository.PostRepository
import dev.vidaemcorrotinaapi.dto.NewPost
import dev.vidaemcorrotinaapi.dto.UpdatePost
import dev.vidaemcorrotinaapi.mapper.toEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import javax.validation.Valid

@RestController
@RequestMapping("/posts")
class PostController(val postRepository: PostRepository) {

    @GetMapping
    fun listPosts(): MutableList<PostEntity> {
        return postRepository.findAll()
    }

    @GetMapping("/{id}")
    fun findPostById(@PathVariable id: String): ResponseEntity<PostEntity> {
        val result = postRepository.findById(UUID.fromString(id))
        return when {
            result.isPresent -> ResponseEntity.status(HttpStatus.OK).body(result.get())
            else -> ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @PostMapping
    fun createPost(@RequestBody @Valid newPost: NewPost): ResponseEntity<PostEntity> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(postRepository.save(newPost.toEntity()))
    }

    @PutMapping("/{id}")
    fun updatePost(@PathVariable id: String, @RequestBody @Valid updatedPost: UpdatePost): ResponseEntity<PostEntity> {
        val result = postRepository.findById(UUID.fromString(id))
        return when {
            result.isPresent -> {
                result.get().title = updatedPost.title ?: result.get().title
                result.get().text = updatedPost.text ?: result.get().text
                result.get().active = updatedPost.active ?: result.get().active
                return ResponseEntity.status(HttpStatus.OK)
                    .body(postRepository.save(result.get()))
            }
            else -> ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }
}
