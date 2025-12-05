package com.parking.mediterranean.condominium.parking.repository;

import com.parking.mediterranean.condominium.parking.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    boolean existsByPlate(String plate);

    long countByApartmentIdAndParked(Long apartmentId, boolean parked);
}
