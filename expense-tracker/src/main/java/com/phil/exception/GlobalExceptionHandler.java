package com.phil.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice //this means: apply this to all controllers
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String,Object> handleIllegalArgument(IllegalArgumentException ex){
        Map<String,Object> error = new HashMap<>();

        error.put("message:",ex.getMessage());
        error.put("status:", HttpStatus.BAD_REQUEST.value());
        return error;
    }
}
