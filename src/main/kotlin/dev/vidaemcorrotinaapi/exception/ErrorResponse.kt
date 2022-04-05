package dev.vidaemcorrotinaapi.exception

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL

@JsonInclude(NON_NULL)
data class ErrorResponse(
    val error: String?,
    val message: String?
)
