package com.parking.mediterranean.condominium.parking.dto.bicycle;

import com.parking.mediterranean.condominium.parking.entity.Bicycle;

public record BicycleListDTO(
        String model,
        String color,
        String identifier,
        Long apartmentId
) {
    public BicycleListDTO(Bicycle bicycle) {
        this(
                bicycle.getModel(),
                bicycle.getColor(),
                bicycle.getIdentifier(),
                bicycle.getApartment() != null ? bicycle.getApartment().getId() : null
        );
    }
}
