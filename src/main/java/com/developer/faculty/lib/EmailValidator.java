package com.developer.faculty.lib;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
    private static final String EMAIL_VALIDATION_REGEX = "^(\\w+\\.*\\w+)@(\\D+\\.\\D+)$";

    @Override
    public boolean isValid(String field, ConstraintValidatorContext context) {
        return field != null && field.matches(EMAIL_VALIDATION_REGEX);
    }
}
