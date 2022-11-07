package dev.vidaemcorrotinaapi.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
import dev.vidaemcorrotinaapi.entity.enums.Role
import java.time.LocalDateTime
import java.util.UUID

@JsonInclude(NON_NULL)
data class UserInfos(
    val id: UUID,
    val name: String,
    val email: String,
    val cpf: String,
    val role: Role,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?,
)
