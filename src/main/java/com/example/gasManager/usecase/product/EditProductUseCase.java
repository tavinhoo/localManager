package com.example.gasManager.usecase.product;

import com.example.gasManager.core.domain.model.Product;

public interface EditProductUseCase {
    Product editProduct(Long productId, Product product);
}
