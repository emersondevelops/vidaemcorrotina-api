package dev.vidaemcorrotinaapi.service

import dev.vidaemcorrotinaapi.dto.NewUser
import dev.vidaemcorrotinaapi.entity.UserEntity
import dev.vidaemcorrotinaapi.mapper.toEntity
import dev.vidaemcorrotinaapi.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(val userRepository: UserRepository) {
    fun listAll(): MutableList<UserEntity> {
        return userRepository.findAll()
    }

    fun findById(id: String): UserEntity {
        return userRepository.findById(UUID.fromString(id)).get()
    }

    fun create(newUser: NewUser): UserEntity {
        return userRepository.save(newUser.toEntity())
    }
}
