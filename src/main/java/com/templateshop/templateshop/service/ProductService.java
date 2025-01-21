package com.templateshop.templateshop.service;

import com.templateshop.templateshop.model.Product;
import com.templateshop.templateshop.repository.ProductRepository;
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
