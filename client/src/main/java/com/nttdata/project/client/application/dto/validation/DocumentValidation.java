package com.nttdata.project.client.application.dto.validation;

import com.nttdata.project.client.application.dto.validation.impl.DocumentValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Constraint: This annotation is used to define a custom constraint.
 * validatedBy: Specifies the class that implements the validation logic.
 * DocumentValidator.class is the class that will contain the validation logic.
 * @Target: Specifies the program elements to which this annotation can be applied.
 * @Retention: Specifies how long the annotation is retained.
 * @interface: Defines a new annotation.
 * message(): Defines the error message to be displayed if validation fails.
 * groups(): Used to group constraints.
 * payload(): Used to carry additional information about the validation constraint.
 */
@Constraint(validatedBy = DocumentValidator.class)
@Target( { ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface DocumentValidation {
    String message() default "Invalid document number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
