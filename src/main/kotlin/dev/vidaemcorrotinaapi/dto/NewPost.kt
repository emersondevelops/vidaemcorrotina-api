package dev.vidaemcorrotinaapi.dto

import javax.validation.constraints.NotBlank

data class NewPost(
    @get:NotBlank var title: String?,
    @get:NotBlank var text: String?
)
