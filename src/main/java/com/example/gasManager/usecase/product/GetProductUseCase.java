package com.example.gasManager.usecase.product;

import com.example.gasManager.core.domain.Product;

public interface GetProductUseCase {
    Product getProductById(Long productId);
}
