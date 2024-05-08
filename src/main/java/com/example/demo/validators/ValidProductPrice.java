package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 *
 *
 *
 */
// Validator to make sure the price of products aren't less than the parts used in it
@Constraint(validatedBy = {PriceProductValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidProductPrice {
    String message() default "Price of the product must be greater than the sum of the price of the parts.";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
