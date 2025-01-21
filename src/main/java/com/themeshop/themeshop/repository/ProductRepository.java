package com.themeshop.themeshop.repository;

import com.themeshop.themeshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

}
