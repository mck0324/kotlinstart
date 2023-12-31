package com.example.kotlinboard.advice

import com.example.kotlinboard.controller.exception.ExceptionApiController
import com.example.kotlinboard.controller.put.PutApiController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

//@RestControllerAdvice
class GlobalControllerAdvice {

    @ExceptionHandler(value = [RuntimeException::class])
    fun exception(e : RuntimeException): String {
        return "Server Error"
    }

    @ExceptionHandler(value = [IndexOutOfBoundsException::class])
    fun indexOutOfBoundsException(e : IndexOutOfBoundsException): ResponseEntity<String> {
        println("Global controller exception handler")
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Index Error")
    }
}