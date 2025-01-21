package com.templateshop.templateshop.repository;

import com.templateshop.templateshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

}
