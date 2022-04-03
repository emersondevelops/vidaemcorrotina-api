package dev.vidaemcorrotinaapi

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/posts")
class PostController(val postRepository: PostRepository) {

    @GetMapping
    fun listPosts(): MutableList<PostEntity> {
        return postRepository.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String): ResponseEntity<PostEntity> {
        val result = postRepository.findById(UUID.fromString(id))
        return when {
            result.isPresent -> ResponseEntity.status(HttpStatus.OK).body(result.get())
            else -> ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }
}
