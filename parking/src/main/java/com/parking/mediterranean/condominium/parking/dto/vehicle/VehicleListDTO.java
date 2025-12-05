package com.parking.mediterranean.condominium.parking.dto.vehicle;

import com.parking.mediterranean.condominium.parking.entity.Vehicle;

public record VehicleListDTO(
        String plate,
        String model,
        String color,
        Long apartmentId,
        boolean parked
) {
    public VehicleListDTO(Vehicle vehicle) {
        this(
                vehicle.getPlate(),
                vehicle.getModel(),
                vehicle.getColor(),
                vehicle.getApartment() != null ? vehicle.getApartment().getId() : null,
                vehicle.isParked()
        );
    }
}
