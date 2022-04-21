package dev.vidaemcorrotinaapi.exception

import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class PostsExceptionHandler {

    @ExceptionHandler
    fun handleMethodArgumentNotValidException(exception: MethodArgumentNotValidException):
            ResponseEntity<MutableList<ErrorResponse>> {
        return ResponseEntity.status(BAD_REQUEST)
            .body(exception.fieldErrors.map {
                ErrorResponse(error = it.field, message = it.defaultMessage)
            }.toMutableList())
    }

    @ExceptionHandler
    fun handleIllegalArgumentException(exception: IllegalArgumentException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(BAD_REQUEST)
            .body(ErrorResponse(error = null, message = exception.message))
    }

    @ExceptionHandler
    fun handleHttpMessageNotReadableException(exception: HttpMessageNotReadableException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(BAD_REQUEST)
            .body(ErrorResponse(error = null, message = exception.rootCause?.message))
    }

    @ExceptionHandler
    fun handleException(exception: Exception): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR)
            .body(ErrorResponse(error = null, message = exception.message))
    }
}
