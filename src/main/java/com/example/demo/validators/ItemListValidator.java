package com.example.demo.validators;

import com.example.demo.domain.Part;
import org.springframework.context.ApplicationContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;

// Validator for ItemListCheck
public class ItemListValidator implements ConstraintValidator<ItemListCheck, Part> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;


    @Override
    public void initialize(ItemListCheck constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    // Returns true if inventory item is within range, otherwise false
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if(context==null) return true;
        if(context!=null)myContext=context;
        PartService repo = myContext.getBean(PartServiceImpl.class);
        if (part.getId() != 0) {
            Part myPart = repo.findById((int) part.getId());

            if (part.getInv() >= part.getInvLow() && part.getInv() <= part.getInvHigh()) {
                return true;
            }
            else {
                constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory must be within minimum and maximum.")
                        .addPropertyNode("inv")
                        .addConstraintViolation();
                return false;
            }
        } else {
            return true;
        }
    }
}