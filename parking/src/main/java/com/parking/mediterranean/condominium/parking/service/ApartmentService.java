package com.parking.mediterranean.condominium.parking.service;

import com.parking.mediterranean.condominium.parking.dto.apartment.ApartmentListDTO;
import com.parking.mediterranean.condominium.parking.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ApartmentService {

    @Autowired
    ApartmentRepository repository;

    public Page<ApartmentListDTO> list(Pageable pageable) {
        return repository
                .findAllSorted(pageable)
                .map(ApartmentListDTO::new);
    }
}
