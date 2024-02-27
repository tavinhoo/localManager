package com.example.gasManager.service;

import com.example.gasManager.DTO.SaleDTO;
import com.example.gasManager.model.Sale;
import com.example.gasManager.repository.CustomerRepository;
import com.example.gasManager.repository.SaleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Optional<Sale> saveSale(SaleDTO saleDTO) {
        try {
            Sale sale0 = new Sale();
            BeanUtils.copyProperties(saleDTO, sale0);
            sale0.setSaleDate(LocalDateTime.now());
            return Optional.of(saleRepository.save(sale0));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
