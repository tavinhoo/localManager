package com.example.gasManager.service;

import com.example.gasManager.DTO.CustomerDTO;
import com.example.gasManager.DTO.ProductDTO;
import com.example.gasManager.model.Customer;
import com.example.gasManager.model.Product;
import com.example.gasManager.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> findProductById(Long id) {
        if(productRepository.existsById(id)) {
            return productRepository.findById(id);
        }
        return Optional.empty();
    }

    public List<Product> findAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    public Optional<Product> saveProduct(ProductDTO productDTO) {
        Product product0 = new Product();
        BeanUtils.copyProperties(productDTO, product0);

        boolean alreadyExits = false;

        for (Product prod : productRepository.findAll()) {
            if (product0.getName().compareTo(prod.getName()) == 0) {
                alreadyExits = true;
                break;
            }
        }

        if (alreadyExits) {
            return Optional.empty();
        }
        return Optional.of(productRepository.save(product0));
    }

    public Optional<Product> updateCustomer(Long id, ProductDTO productDTO) {
        Optional<Product> prod0 = productRepository.findById(id);

        if (prod0.isEmpty()) {
            return Optional.empty();
        }

        BeanUtils.copyProperties(productDTO, prod0.get());
        return Optional.of(productRepository.save(prod0.get()));
    }
}
