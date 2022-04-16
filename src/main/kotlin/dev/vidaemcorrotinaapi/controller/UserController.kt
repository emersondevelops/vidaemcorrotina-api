package dev.vidaemcorrotinaapi.controller

import dev.vidaemcorrotinaapi.dto.NewUser
import dev.vidaemcorrotinaapi.entity.UserEntity
import dev.vidaemcorrotinaapi.service.UserService
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UserController(val userService: UserService) {

    @GetMapping
    fun listUsers(): MutableList<UserEntity> {
        return userService.listAll()
    }

    @GetMapping("/{id}")
    fun findUserById(@PathVariable id: String): ResponseEntity<UserEntity> {
        return try {
            ResponseEntity.status(OK).body(userService.findById(id))
        } catch (exception: NoSuchElementException) {
            ResponseEntity.status(NOT_FOUND).build()
        }
    }

    @PostMapping
    fun createUser(@RequestBody @Valid newUser: NewUser): ResponseEntity<UserEntity> {
        return ResponseEntity.status(CREATED).body(userService.create(newUser))
    }
}
