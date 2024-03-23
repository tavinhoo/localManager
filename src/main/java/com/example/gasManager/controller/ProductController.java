package com.example.gasManager.controller;

import com.example.gasManager.DTO.ProductDTO;
import com.example.gasManager.model.Product;
import com.example.gasManager.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<Product> saveProduct(@RequestBody ProductDTO productDTO) {
        Product product0 = new Product();
        BeanUtils.copyProperties(productDTO, product0);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(product0));
    }
}
