package com.parking.mediterranean.condominium.parking.dto.bicycle;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BicycleCreateDTO(
        String model,
        @NotBlank
        String color,
        @NotBlank
        String identifier,
        @NotNull
        Long apartmentId
) {
}
