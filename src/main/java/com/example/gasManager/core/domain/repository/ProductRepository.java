package com.example.gasManager.core.domain.repository;

import com.example.gasManager.core.domain.model.Product;

import java.util.List;

public interface ProductRepository {
    void save(Product product);
    Product findById(long id);
    List<Product> findAll();
    void delete(Long productId);
}
