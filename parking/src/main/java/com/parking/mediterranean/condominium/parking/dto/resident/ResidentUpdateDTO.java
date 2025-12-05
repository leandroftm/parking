package com.parking.mediterranean.condominium.parking.dto.resident;

import jakarta.validation.constraints.NotNull;

public record ResidentUpdateDTO(
        @NotNull
        Long apartmentId
) {
}
