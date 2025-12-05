package com.parking.mediterranean.condominium.parking.dto.vehicle;

public record VehicleUpdateDTO(
        Boolean parked,
        Long apartmentId
) {
}
