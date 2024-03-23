package com.example.gasManager.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDTO(@NotBlank String name, @NotNull Double price) {
}
