package com.example.gasManager.application.ports.output;

import com.example.gasManager.core.domain.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductPersistencePort {
    void save(Product product);
    Product findById(long id);
    List<Product> findAll();
    void delete(Long productId);

}
