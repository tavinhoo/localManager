package com.example.gasManager.usecase.product;

import com.example.gasManager.core.domain.model.Product;

public interface GetProductUseCase {
    Product getProductById(Long productId);
}
