package com.parking.mediterranean.condominium.parking.repository;

import com.parking.mediterranean.condominium.parking.entity.Bicycle;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BicycleRepository extends JpaRepository<Bicycle, Long> {
    boolean existsByIdentifier(@NotNull String identifier);
}
