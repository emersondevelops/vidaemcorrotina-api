package dev.vidaemcorrotinaapi.controller

import dev.vidaemcorrotinaapi.dto.NewPost
import dev.vidaemcorrotinaapi.dto.UpdatePost
import dev.vidaemcorrotinaapi.entity.PostEntity
import dev.vidaemcorrotinaapi.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/posts")
class PostController(val postService: PostService) {

    @GetMapping
    fun listPosts(): MutableList<PostEntity> {
        return postService.listAll()
    }

    @GetMapping("/{id}")
    fun findPostById(@PathVariable id: String): ResponseEntity<PostEntity> {
        return try {
            ResponseEntity.status(HttpStatus.OK).body(postService.findById(id))
        } catch (exception: NoSuchElementException) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @PostMapping
    fun createPost(@RequestBody @Valid newPost: NewPost): ResponseEntity<PostEntity> {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.create(newPost))
    }

    @PutMapping("/{id}")
    fun updatePost(@PathVariable id: String, @RequestBody @Valid updatedPost: UpdatePost): ResponseEntity<PostEntity> {
        return try {
            ResponseEntity.status(HttpStatus.OK).body(postService.update(id, updatedPost))
        } catch (exception: NoSuchElementException) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }
}
