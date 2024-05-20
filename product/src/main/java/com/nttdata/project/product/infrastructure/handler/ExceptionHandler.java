package com.nttdata.project.product.infrastructure.handler;

import com.nttdata.project.product.application.dto.response.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ProductResponse> handleException(MethodArgumentNotValidException exception){
        return new ResponseEntity<>(ProductResponse.builder()
                .code("400")
                .message(exception.getBindingResult().getFieldErrors().get(0).getDefaultMessage())
                .build(), HttpStatus.BAD_REQUEST);

    }
}