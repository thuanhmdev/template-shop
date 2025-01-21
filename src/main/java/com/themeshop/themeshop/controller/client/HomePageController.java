package com.themeshop.themeshop.controller.client;

import com.themeshop.themeshop.model.Product;
import com.themeshop.themeshop.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class HomePageController {
    private final ProductService productService;
    public HomePageController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String getHomePage(Model model) {
        Pageable pageable = PageRequest.of(0 , 10);
        Page<Product> productPage = this.productService.findAll(pageable);
        List<Product> products = productPage.getContent();
        model.addAttribute("products", products);
        return "client/home/index";
    }
}
