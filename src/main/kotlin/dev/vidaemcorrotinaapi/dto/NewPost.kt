package dev.vidaemcorrotinaapi.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class NewPost(
    @get:NotBlank val title: String?,
    @get:NotBlank val text: String?,
    @get:NotNull val authorId: String?
)
