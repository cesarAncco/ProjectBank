package com.nttdata.project.credit.infrastructure.handler;

import com.nttdata.project.credit.application.dto.response.CreditResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CreditResponse> handleException(MethodArgumentNotValidException exception){
        return new ResponseEntity<>(CreditResponse.builder()
                .code("400")
                .message(exception.getBindingResult().getFieldErrors().get(0).getDefaultMessage())
                .build(), HttpStatus.BAD_REQUEST);

    }
}
