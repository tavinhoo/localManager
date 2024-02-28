package com.example.gasManager.controller;

import com.example.gasManager.DTO.SaleDTO;
import com.example.gasManager.model.Sale;
import com.example.gasManager.repository.CustomerRepository;
import com.example.gasManager.repository.SaleRepository;
import com.example.gasManager.service.SaleService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/customer/sale")
    public ResponseEntity listAllSales() {
            return ResponseEntity.status(HttpStatus.OK).body(saleService.getAllSales());
    }

    @PostMapping("/customer/{id}/sale")
    public ResponseEntity createSale(@PathVariable(value = "id") Long id, @RequestBody SaleDTO inputSale) {
      Optional<Sale> sale0 = saleService.saveSale(inputSale);
      if(sale0.isEmpty()) {
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("OPERAÇÃO NÃO REALIZADA");
      }

      return ResponseEntity.status(HttpStatus.OK).body("SALE CREATED");
    }

}
