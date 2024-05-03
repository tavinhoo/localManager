package com.example.gasManager.usecase.Product;

import com.example.gasManager.core.domain.Product;

public interface GetProductUseCase {
    Product getProductById(Long productId);
}
