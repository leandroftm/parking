package com.parking.mediterranean.condominium.parking.repository;

import com.parking.mediterranean.condominium.parking.entity.Building;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

public interface BuildingRepository extends JpaRepository<Building, Long> {
    Page<Building> findAllByOrderByCodeAsc(Pageable page);
}
