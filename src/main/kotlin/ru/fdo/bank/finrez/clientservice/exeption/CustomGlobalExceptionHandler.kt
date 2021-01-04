package ru.fdo.bank.finrez.clientservice.exeption

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime

@ControllerAdvice
class CustomGlobalExceptionHandler : ResponseEntityExceptionHandler() {

    override fun handleMethodArgumentNotValid(ex: MethodArgumentNotValidException,
                                              headers: HttpHeaders,
                                              status: HttpStatus,
                                              request: WebRequest): ResponseEntity<Any> {
        val errors = ex.bindingResult.fieldErrors
                .map { fieldError -> mapOf("field" to fieldError.field,
                        "message" to fieldError.defaultMessage,
                        "wrong value" to fieldError.rejectedValue)
                }

        val body = mapOf("timestamp" to LocalDateTime.now(),
                            "status" to status.value(),
                            "errors" to errors,
                            "message" to "validation error")

        return ResponseEntity(body, headers, status)
    }
}