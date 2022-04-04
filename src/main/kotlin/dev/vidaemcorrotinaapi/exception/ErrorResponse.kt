package dev.vidaemcorrotinaapi.exception

data class ErrorResponse(
    val field: String,
    val error: String
)
