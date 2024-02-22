package com.example.gasManager.DTO;

import com.example.gasManager.model.enums.CustomerGender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerDTO(@NotBlank String name, @NotNull CustomerGender customerGender,
                          @NotBlank String phone_1, String phone_2, @NotBlank String neighborhood,
                          @NotBlank String street, @NotBlank String number, String reference) {
}
