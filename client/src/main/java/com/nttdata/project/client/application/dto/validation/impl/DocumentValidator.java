package com.nttdata.project.client.application.dto.validation.impl;

import com.nttdata.project.client.application.dto.request.ClientRequest;
import com.nttdata.project.client.application.dto.validation.DocumentValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class DocumentValidator implements ConstraintValidator<DocumentValidation, ClientRequest> {
    @Override
    public boolean isValid(ClientRequest clientRequest, ConstraintValidatorContext constraintValidatorContext) {
        switch (clientRequest.getTypeDocument()){
            case "1":
                return Pattern.matches("\\d{8}",clientRequest.getDocument());
            case "2":
                return Pattern.matches("\\d{11}",clientRequest.getDocument());
            default:
                return false;
        }
    }
}
