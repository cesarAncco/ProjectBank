package com.nttdata.project.client.application.dto.validation;

import com.nttdata.project.client.application.dto.validation.impl.DocumentValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DocumentValidator.class)
@Target( { ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface DocumentValidation {
    String message() default "Invalid document number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
