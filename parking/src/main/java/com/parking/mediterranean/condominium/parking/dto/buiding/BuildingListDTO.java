package com.parking.mediterranean.condominium.parking.dto.buiding;

import com.parking.mediterranean.condominium.parking.entity.Building;

public record BuildingListDTO(
        String code,
        String name,
        Integer floors,
        Integer apartmentPerFloor
) {

    public BuildingListDTO(Building building) {
        this(building.getCode(), building.getName(), building.getFloors(), building.getApartmentsPerFloor());
    }
}
