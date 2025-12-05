package com.parking.mediterranean.condominium.parking.dto.vehicle;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record VehicleCreateDTO(
        @NotBlank
        @Size(max = 15)
        String plate,
        @NotBlank
        @Size(max = 30)
        String model,
        @NotBlank
        @Size(max = 30)
        String color,
        @NotNull
        Long apartmentId
) {
}
