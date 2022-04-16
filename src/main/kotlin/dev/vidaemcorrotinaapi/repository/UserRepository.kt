package dev.vidaemcorrotinaapi.repository

import dev.vidaemcorrotinaapi.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository : JpaRepository<UserEntity, UUID> {
}