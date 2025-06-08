package com.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiReponse> ResourceNotFoundException(ResourceNotFoundException ex){
        ApiReponse apiReponse=new ApiReponse(ex.getMessage(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(apiReponse,HttpStatus.NOT_FOUND);

    }
}
