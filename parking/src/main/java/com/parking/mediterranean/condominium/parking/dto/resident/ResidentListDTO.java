package com.parking.mediterranean.condominium.parking.dto.resident;

import com.parking.mediterranean.condominium.parking.entity.Resident;
import com.parking.mediterranean.condominium.parking.entity.enums.ResidentType;

public record ResidentListDTO(
        String name,
        String cpf,
        String phone,
        ResidentType type,
        Long apartmentId
) {
    public ResidentListDTO(Resident resident) {
        this(
                resident.getName(),
                resident.getCpf(),
                resident.getPhone(),
                resident.getType(),
                resident.getApartment() != null ? resident.getApartment().getId() : null);
    }
}
