package dev.vidaemcorrotinaapi.dto

import dev.vidaemcorrotinaapi.entity.enums.Role
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class NewUser(
    @get:NotBlank val name: String?,
    @get:NotNull val role: Role?
)
