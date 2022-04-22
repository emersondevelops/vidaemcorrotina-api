package dev.vidaemcorrotinaapi.controller

import dev.vidaemcorrotinaapi.dto.NewUser
import dev.vidaemcorrotinaapi.dto.UserInfos
import dev.vidaemcorrotinaapi.mapper.toUserInfosDto
import dev.vidaemcorrotinaapi.service.UserService
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UserController(val userService: UserService) {

    @GetMapping
    fun listUsers(): MutableList<UserInfos> {
        return userService.listAll()
    }

    @GetMapping("/{id}")
    fun findUserById(@PathVariable id: String): ResponseEntity<UserInfos> {
        return try {
            ResponseEntity.status(OK).body(userService.findById(id).toUserInfosDto())
        } catch (exception: NoSuchElementException) {
            ResponseEntity.status(NOT_FOUND).build()
        }
    }

    @PostMapping
    fun createUser(@RequestBody @Valid newUser: NewUser): ResponseEntity<UserInfos> {
        return ResponseEntity.status(CREATED).body(userService.create(newUser).toUserInfosDto())
    }
}
