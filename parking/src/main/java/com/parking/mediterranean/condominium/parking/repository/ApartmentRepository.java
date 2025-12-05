package com.parking.mediterranean.condominium.parking.repository;

import com.parking.mediterranean.condominium.parking.entity.Apartment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    @Query("""
            SELECT a
            FROM Apartment a
            JOIN a.building b
            ORDER BY b.code ASC, a.number ASC
            """)
    Page<Apartment> findAllSorted(Pageable page);
}
