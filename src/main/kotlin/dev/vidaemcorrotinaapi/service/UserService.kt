package dev.vidaemcorrotinaapi.service

import dev.vidaemcorrotinaapi.dto.NewUser
import dev.vidaemcorrotinaapi.entity.UserEntity
import dev.vidaemcorrotinaapi.mapper.toEntity
import dev.vidaemcorrotinaapi.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService(val userRepository: UserRepository) {
    fun listAll(): MutableList<UserEntity> {
        return userRepository.findAll()
    }

    fun findById(id: String): UserEntity {
        return userRepository.findById(UUID.fromString(id)).get()
    }

    fun create(newUser: NewUser): UserEntity {
        userRepository.findByEmail(newUser.email!!) ?: return userRepository.save(newUser.toEntity())
        throw IllegalArgumentException("user with e-mail '${newUser.email}' already exists")
    }
}
