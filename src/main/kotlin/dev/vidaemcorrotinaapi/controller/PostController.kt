package dev.vidaemcorrotinaapi.controller

import dev.vidaemcorrotinaapi.dto.FullPost
import dev.vidaemcorrotinaapi.dto.NewPost
import dev.vidaemcorrotinaapi.dto.UpdatePost
import dev.vidaemcorrotinaapi.entity.PostEntity
import dev.vidaemcorrotinaapi.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/posts")
class PostController(val postService: PostService) {

    @GetMapping
    fun listPosts(@RequestParam(name = "active", defaultValue = "true") active: Boolean): MutableList<FullPost> {
        return postService.listAll(active)
    }

    @GetMapping("/{id}")
    fun findPostById(@PathVariable id: String): ResponseEntity<FullPost> {
        return try {
            ResponseEntity.status(OK).body(postService.findById(id))
        } catch (exception: NoSuchElementException) {
            ResponseEntity.status(NOT_FOUND).build()
        }
    }

    @PostMapping
    fun createPost(@RequestBody @Valid newPost: NewPost): ResponseEntity<FullPost> {
        return ResponseEntity.status(CREATED).body(postService.create(newPost))
    }

    @PutMapping("/{id}")
    fun updatePost(@PathVariable id: String, @RequestBody @Valid updatedPost: UpdatePost): ResponseEntity<FullPost> {
        return try {
            ResponseEntity.status(OK).body(postService.update(id, updatedPost))
        } catch (exception: NoSuchElementException) {
            ResponseEntity.status(NOT_FOUND).build()
        }
    }
}
