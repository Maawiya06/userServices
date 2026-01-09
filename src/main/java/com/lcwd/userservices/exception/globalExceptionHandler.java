package com.lcwd.userservices.exception;

import com.lcwd.userservices.payload.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class globalExceptionHandler {

    public ResponseEntity<ApiResponse> handleResourceNotFoundException(){

    }
}
