package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.PartService;
import com.example.demo.service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// Controller for the 3 pages added into the project
@Controller
public class AboutPageController {


    // Create mapping for the about page
    @GetMapping("/about")
    public ModelAndView viewAboutPage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("about.html");
        return view;
    }

    // Create mapping for the resources page
    @GetMapping("/resources")
    public ModelAndView viewResourcesPage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("resources.html");
        return view;
    }

    // Create mapping for the contact page
    @GetMapping("/contact")
    public ModelAndView viewContactPage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("contact.html");
        return view;
    }
}