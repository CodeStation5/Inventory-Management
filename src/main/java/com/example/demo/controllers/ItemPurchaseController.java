package com.example.demo.controllers;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.example.demo.service.ProductService;
import com.example.demo.domain.Product;

@Controller
public class ItemPurchaseController {

    @Autowired
    private ApplicationContext appView;

    // Connect main page to buy products page
    @GetMapping("/buyproduct")
    public ModelAndView buyproduct(@RequestParam("productID") int theId) {

        ProductService repo = appView.getBean(ProductServiceImpl.class);
        Product product = repo.findById(theId);
        ModelAndView modView = new ModelAndView();

        if(product.getInv() == 0) {
            modView.setViewName("ItemNotSold.html");
            return modView;
        }
        else {
            product.setInv(product.getInv() - 1);
            repo.save(product);
            modView.setViewName("ItemSold.html");
            return modView;
        }
    }

}
