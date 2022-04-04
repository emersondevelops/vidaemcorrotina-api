package dev.vidaemcorrotinaapi.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class PostsExceptionHandler {

    @ExceptionHandler
    fun handleMethodArgumentNotValidException(exception: MethodArgumentNotValidException):
            ResponseEntity<MutableList<ErrorResponse>> {
        val errors = mutableListOf<ErrorResponse>()
        for (error in exception.fieldErrors)
            errors.add(ErrorResponse(field = error.field, error = error.defaultMessage ?: ""))
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors)
    }
}
