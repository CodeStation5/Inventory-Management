package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

// Validator for @ValidPartsForProduct
public class ValidPartsProductValidator implements ConstraintValidator<ValidPartsForProduct, Product> {
    @Autowired
    private ApplicationContext view;
    public static ApplicationContext view2;

    @Override
    public void initialize(ValidPartsForProduct constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Product product, ConstraintValidatorContext constraintValidatorContext) {
        if (view == null) {
            return true;
        }
        if (view != null) {
            view2 = view;
        }
        ProductService productInv = view2.getBean(ProductServiceImpl.class);
        PartService partRepo = view2.getBean(PartServiceImpl.class);

        if (product.getId() != 0) {
            Product myProduct = productInv.findById((int) product.getId());
            for (Part part : myProduct.getParts()) {
                if (part.getInv() < product.getInv() - part.getInvLow()) {
                    return false;
                }
            }
            return true;
        }
        else {
            return true;
        }
    }
}