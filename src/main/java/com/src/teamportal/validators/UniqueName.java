package com.src.teamportal.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = UniqueNameValidator.class)
public @interface UniqueName {
    String message() default "Not Valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
