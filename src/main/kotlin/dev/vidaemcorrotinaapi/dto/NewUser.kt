package dev.vidaemcorrotinaapi.dto

import dev.vidaemcorrotinaapi.entity.enums.Role
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class NewUser(
    @get:NotBlank val name: String?,
    @get:NotBlank val email: String?,
    @get:NotNull val role: Role?,
    @get:NotBlank val password: String?
)
