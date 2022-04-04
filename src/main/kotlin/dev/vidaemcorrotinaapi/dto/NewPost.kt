package dev.vidaemcorrotinaapi.dto

import dev.vidaemcorrotinaapi.PostEntity
import javax.validation.constraints.NotBlank

data class NewPost(
    @get:NotBlank var title: String?,
    @get:NotBlank var text: String?
) {
    fun toEntity(): PostEntity {
        return PostEntity(
            title = this.title!!,
            text = this.text!!
        )
    }
}
