package com.parking.mediterranean.condominium.parking.service;

import com.parking.mediterranean.condominium.parking.dto.bicycle.BicycleCreateDTO;
import com.parking.mediterranean.condominium.parking.dto.bicycle.BicycleListDTO;
import com.parking.mediterranean.condominium.parking.dto.bicycle.BicycleUpdateDTO;
import com.parking.mediterranean.condominium.parking.entity.Apartment;
import com.parking.mediterranean.condominium.parking.entity.Bicycle;
import com.parking.mediterranean.condominium.parking.exception.DuplicateResourceException;
import com.parking.mediterranean.condominium.parking.exception.ResourceNotFoundException;
import com.parking.mediterranean.condominium.parking.repository.ApartmentRepository;
import com.parking.mediterranean.condominium.parking.repository.BicycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BicycleService {

    @Autowired
    BicycleRepository repository;
    @Autowired
    ApartmentRepository apartmentRepository;

    @Transactional
    public Long create(BicycleCreateDTO data) {
        checkIdentifierAvailable(data.identifier());

        Bicycle bicycle = new Bicycle(data.model(), data.color(), data.identifier());
        bicycle.setApartment(findApartment(data.apartmentId()));

        repository.save(bicycle);
        return bicycle.getId();
    }

    public Page<BicycleListDTO> list(Pageable pageable) {
        return repository.findAll(pageable)
                .map(BicycleListDTO::new);
    }

    @Transactional
    public void update(Long id, BicycleUpdateDTO data) {
        Bicycle bicycle = findBicycle(id);

        if (data.model() != null)
            bicycle.setModel(data.model());

        if (data.color() != null)
            bicycle.setColor(data.color());

        if (data.apartmentId() != null)
            bicycle.setApartment(findApartment(data.apartmentId()));
        else
            bicycle.setApartment(null);
    }

    @Transactional
    public void delete(Long id) {
        Bicycle bicycle = findBicycle(id);
        repository.delete(bicycle);
    }

    public void checkIdentifierAvailable(String identifier) {
        if (repository.existsByIdentifier(identifier))
            throw new DuplicateResourceException("Bicycle identifier already exists");
    }

    public Apartment findApartment(Long apartmentId) {
        return apartmentRepository.findById(apartmentId).orElseThrow(() -> new ResourceNotFoundException("Apartment not found"));
    }

    public Bicycle findBicycle(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bicycle not found" + id));
    }
}
