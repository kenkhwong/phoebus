package com.example.phoebus.validator;

import com.example.phoebus.constraints.Alphabetic;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AlphabetValidator implements ConstraintValidator<Alphabetic,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;

        for (Character c : value.toCharArray()) {
            if (!Character.isLetter(c))
                return false;
        }

        return true;
    }
}
