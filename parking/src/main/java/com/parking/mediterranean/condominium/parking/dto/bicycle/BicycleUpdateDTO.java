package com.parking.mediterranean.condominium.parking.dto.bicycle;

public record BicycleUpdateDTO(
        String model,
        String color,
        Long apartmentId
) {
}
