package com.lcwd.userservices.exception;

import com.lcwd.userservices.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class globalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
        String message = ex.getMessage();
        ApiResponse build = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();

    }
}
