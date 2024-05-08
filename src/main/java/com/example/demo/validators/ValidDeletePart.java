package com.example.demo.validators;

import javax.validation.Payload;

/**
 *
 *
 *
 *
 */
// Validator to make sure parts aren't used in a product
public @interface ValidDeletePart {
    String message() default "Part cannot be deleted if used in a product.";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
