package com.example.gasManager.service;

import com.example.gasManager.DTO.ProductDTO;
import com.example.gasManager.exceptions.ProductAlreadyExists;
import com.example.gasManager.exceptions.ProductNotFound;
import com.example.gasManager.model.Product;
import com.example.gasManager.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProducts() {
        List<Product> list0 = productRepository.findAll();
        return list0;
    }

    public Optional<Product> findProductById(Long id) {
        if(!productRepository.existsById(id)) {
           throw new ProductNotFound("Produto não econtrado!");
        }
        return productRepository.findById(id);
    }

    public Optional<Product> saveProduct(ProductDTO product) {
        if (productRepository.existsByName(product.name())) {
            throw new ProductAlreadyExists("Já existe um produto com este nome!");
        }
        Product product0 = new Product();
        BeanUtils.copyProperties(product, product0);
        return Optional.of(productRepository.save(product0));
    }

    public Optional<Product> updateProduct(Long id, ProductDTO product) {
        if(!productRepository.existsById(id)) {
            throw new ProductNotFound("Produto não econtrado!");
        }
        Product product0 = productRepository.findById(id).get();
        BeanUtils.copyProperties(product, product0);
        return Optional.of(productRepository.save(product0));
    }

    public Optional<Object> removeProduct(Long id) {
        if(!productRepository.existsById(id)) {
            throw new ProductNotFound("Produto não econtrado!");
        }
        productRepository.deleteById(id);
        return Optional.of("Produto Deletado!");
    }
}
