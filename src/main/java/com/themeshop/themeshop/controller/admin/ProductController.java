package com.themeshop.themeshop.controller.admin;

import com.themeshop.themeshop.model.Product;
import com.themeshop.themeshop.service.ProductService;
import com.themeshop.themeshop.service.UploadService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
    private final ProductService productService;
    private final UploadService uploadService;

    public ProductController(ProductService productService, UploadService uploadService) {
        this.productService = productService;
        this.uploadService = uploadService;
    }

    @GetMapping("")
    public String getProductpage(Model model, @RequestParam("page") Optional<String> pageOptional, @RequestParam("pageSize") Optional<String> pageSizeOptional) {
        int page = pageOptional.isPresent() ? Integer.parseInt(pageOptional.get()) : 1;
        int pageSize = pageSizeOptional.isPresent() ? Integer.parseInt(pageSizeOptional.get()) : 10;
        Pageable pageable = PageRequest.of(page - 1 , pageSize);
        Page<Product> productPage = this.productService.findAll(pageable);
        List<Product> products = productPage.getContent();
        System.out.println("products = " + products.toString());
        model.addAttribute("products", products);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", productPage.getTotalPages());
        return "admin/product/index";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable("id") String id) {
        Product product = this.productService.getById(id);
        model.addAttribute("product", product);
        model.addAttribute("id", id);
        return "admin/product/detail";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "admin/product/create";
    }

    @PostMapping("/create")
    public String handleCreate(@ModelAttribute @Valid Product product, BindingResult bindingResult, @RequestParam("file") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            return "admin/product/create";
        }
        String imageOfProduct = this.uploadService.handleSaveUploadFile(file, "product");
        product.setImage(imageOfProduct);
        this.productService.handleCreate(product);
        return "redirect:/admin/product";
    }

    @GetMapping("/update/{id}")
    public String getUpdatePage(Model model, @PathVariable("id") String id) {
        Product product = this.productService.getById(id);
        model.addAttribute("product", product);
        model.addAttribute("id", id);
        return "admin/product/update";
    }

    @PostMapping("/update")
    public String handleUpdate(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult, @RequestParam("file") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            return "admin/product/update";
        }
        Product productById = this.productService.getById(product.getId());

        if (productById != null) {
            if (!file.isEmpty()) {
                String imageOfProduct = this.uploadService.handleSaveUploadFile(file, "product");
                productById.setImage(imageOfProduct);
            }
            productById.setName(product.getName());
            productById.setDescription(product.getDescription());
            productById.setPrice(product.getPrice());
            this.productService.handleUpdate(productById);
        }
        return "redirect:/admin/product";
    }

    @GetMapping("/delete/{id}")
    public String getDeletePage(Model model, @PathVariable("id") String id) {
        Product product = this.productService.getById(id);
        model.addAttribute("id", id);
        model.addAttribute("product", product);
        return "admin/product/delete";
    }

    @PostMapping("/delete")
    public String handleDelete(@ModelAttribute("product") Product product) {
        this.productService.handleDelete(product.getId());
        return "redirect:/admin/product";
    }
}
