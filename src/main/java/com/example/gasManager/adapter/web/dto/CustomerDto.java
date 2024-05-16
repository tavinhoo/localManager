package com.example.gasManager.adapter.web.dto;

import com.example.gasManager.core.domain.enums.CustomerGender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerDto(

        @NotBlank String name,
        @NotNull CustomerGender customerGender,
        @NotBlank String phone1,
        String phone2,
        @NotBlank String neighborhood,
        @NotBlank String street,
        @NotBlank String number,
        @NotBlank String landmark
        ) {
}
