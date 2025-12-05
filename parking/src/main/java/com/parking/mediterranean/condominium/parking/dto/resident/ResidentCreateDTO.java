package com.parking.mediterranean.condominium.parking.dto.resident;

import com.parking.mediterranean.condominium.parking.entity.enums.ResidentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ResidentCreateDTO(
        @NotBlank
        @Size(max = 60)
        String name,
        @NotBlank
        @Size(max = 15)
        String cpf,
        @NotBlank
        @Size(max = 15)
        String phone,
        @NotNull
        ResidentType type,
        @NotNull
        Long apartmentId
) {
}
