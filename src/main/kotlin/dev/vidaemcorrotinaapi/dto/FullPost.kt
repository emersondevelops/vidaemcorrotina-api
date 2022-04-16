package dev.vidaemcorrotinaapi.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
import java.time.LocalDateTime
import java.util.UUID

@JsonInclude(NON_NULL)
data class FullPost(
    val id: UUID,
    val title: String,
    val text: String,
    val author: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?,
)
