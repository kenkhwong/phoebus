package com.example.phoebus.constraints;

import com.example.phoebus.validator.AlphabetValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = AlphabetValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Alphabetic {
    String message() default "Must be alphabetic";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
