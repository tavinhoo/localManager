package com.example.gasManager.DTO;

import jakarta.validation.constraints.NotNull;

public record SaleDTO(@NotNull Double totalValue, @NotNull Long id_customer) {
}
