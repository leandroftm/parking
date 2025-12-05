package com.parking.mediterranean.condominium.parking.repository;

import com.parking.mediterranean.condominium.parking.entity.Resident;
import com.parking.mediterranean.condominium.parking.entity.enums.ResidentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ResidentRepository extends JpaRepository<Resident, Long> {
    boolean existsByCpf(String cpf);

    boolean existsByApartmentIdAndType(Long id, @NotNull ResidentType type);

    boolean existsByPhone(String phone);

    Page<Resident> findAllByOrderByApartment_NumberAscApartment_Building_CodeAscNameAsc(Pageable pageable);


}
