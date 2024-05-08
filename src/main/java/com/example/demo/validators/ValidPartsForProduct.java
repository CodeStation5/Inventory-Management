package com.example.demo.validators;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import javax.validation.Payload;


@Constraint(validatedBy = {ValidPartsProductValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

// Validator to make sure the current number of parts isn't below the parts set minimum
public @interface ValidPartsForProduct {
    String message()
            default "Parts cannot be below minimum levels";
    Class<?>[] groups()
            default {};
    Class<? extends Payload>[] payload()
            default {};
}