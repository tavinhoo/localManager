package com.example.gasManager.DTO;

import java.time.Instant;

public record OrderDTO(Double totalValue, Instant saleDate, Integer clientId) {

}
