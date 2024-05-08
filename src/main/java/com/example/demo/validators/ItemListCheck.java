package com.example.demo.validators;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import javax.validation.Payload;
import java.lang.annotation.Retention;

// Added constraints to validator
@Constraint(validatedBy = {ItemListValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

// Validates that the inventory is over the max or under the min value
public @interface ItemListCheck {
    // Message sent to warn user about the Inventorys current value
    String message()
            default "Inventory is currently not between min/max values";
    Class<?> [] groups()
            default {};
    Class<? extends Payload> [] payload()
            default {};
}