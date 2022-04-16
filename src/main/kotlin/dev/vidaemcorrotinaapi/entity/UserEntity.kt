package dev.vidaemcorrotinaapi.entity

import dev.vidaemcorrotinaapi.entity.enums.Role
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
class UserEntity(
    @Id
    val id: UUID = UUID.randomUUID(),
    val name: String,
    @Column(unique = true)
    val email: String,
    val role: Role,
    val password: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime? = null,
    var active: Boolean = true
)
