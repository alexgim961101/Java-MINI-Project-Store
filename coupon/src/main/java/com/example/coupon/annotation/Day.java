package com.example.coupon.annotation;

import com.example.coupon.validator.DayFormatValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = { DayFormatValidator.class })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface Day {
    String pattern() default "yyyy-MM-dd HH:mm:ss";
    String message() default "날짜 형식이 올바르지 않습니다.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
