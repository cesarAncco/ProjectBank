package com.nttdata.project.product.infrastructure.handler;

import com.nttdata.project.product.application.dto.response.AccountResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * ExceptionHandler.class to be able to control exceptions when performing an action
 * return a ResponseEntity with the form of AccountResponse
 */

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AccountResponse> handleException(MethodArgumentNotValidException exception){
        return new ResponseEntity<>(AccountResponse.builder()
                .code("400")
                .message(exception.getBindingResult().getFieldErrors().get(0).getDefaultMessage())
                .build(), HttpStatus.BAD_REQUEST);

    }
}
