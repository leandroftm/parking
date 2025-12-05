package com.parking.mediterranean.condominium.parking.dto.apartment;

import com.parking.mediterranean.condominium.parking.entity.Apartment;
import com.parking.mediterranean.condominium.parking.entity.enums.ApartmentType;

public record ApartmentListDTO(
        String number,
        Integer floor,
        ApartmentType type,
        Long buildingId
) {
    public ApartmentListDTO(Apartment apartment) {
        this(
                apartment.getNumber(),
                apartment.getFloor(),
                apartment.getApartmentType(),
                apartment.getBuilding().getId()
        );
    }
}
