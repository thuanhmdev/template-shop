package com.themeshop.themeshop.service;

import com.themeshop.themeshop.model.Product;
import com.themeshop.themeshop.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> findAll(Pageable pageable) {
        return this.productRepository.findAll(pageable);
    }

    public Product getById(String id) {
        return this.productRepository.findById(id).orElse(null);
    }

    public void handleCreate(Product product) {
        this.productRepository.save(product);
    }

    public void handleUpdate(Product product) {
        this.productRepository.save(product);
    }

    public void handleDelete(String id) {
        this.productRepository.deleteById(id);
    }
}
