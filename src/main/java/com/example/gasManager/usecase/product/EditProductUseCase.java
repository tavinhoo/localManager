package com.example.gasManager.usecase.product;

import com.example.gasManager.core.domain.Product;

public interface EditProductUseCase {
    Product editProduct(Long productId, Product product);
}
