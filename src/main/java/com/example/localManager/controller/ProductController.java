package com.example.gasManager.controller;

import com.example.gasManager.model.DTO.ProductDTO;
import com.example.gasManager.model.Product;
import com.example.gasManager.model.exceptions.ProductNotFound;
import com.example.gasManager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO) {
        Optional<Product> prod0 = productService.saveProduct(productDTO);
        if(prod0.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(prod0.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(productService.removeProduct(id));
        } catch (ProductNotFound error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        } catch (RuntimeException error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
