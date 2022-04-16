package dev.vidaemcorrotinaapi.entity

import dev.vidaemcorrotinaapi.entity.enums.Role
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class UserEntity(
    @Id
    val id: UUID = UUID.randomUUID(),
    var name: String,
    var role: Role,
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime? = null,
    var active: Boolean = true
)