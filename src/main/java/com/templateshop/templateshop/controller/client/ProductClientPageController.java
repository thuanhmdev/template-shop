package com.templateshop.templateshop.controller.client;

import com.templateshop.templateshop.model.Product;
import com.templateshop.templateshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductClientPageController {
    private final ProductService productService;

    public ProductClientPageController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public String getDetailProductPage(@PathVariable String id, Model model) {
        Product product = this.productService.getById(id);
        model.addAttribute("product", product);
        return "client/product/detail";
    }
}
