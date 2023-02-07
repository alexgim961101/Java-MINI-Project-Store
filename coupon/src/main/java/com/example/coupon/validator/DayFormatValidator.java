package com.example.coupon.validator;

import com.example.coupon.annotation.Day;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DayFormatValidator implements ConstraintValidator<Day, String> {

    private String pattern;

    @Override
    public void initialize(Day constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            LocalDateTime localDateTime = LocalDateTime.parse(value, DateTimeFormatter.ofPattern(this.pattern));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
