package com.parking.mediterranean.condominium.parking.service;

import com.parking.mediterranean.condominium.parking.dto.vehicle.VehicleCreateDTO;
import com.parking.mediterranean.condominium.parking.dto.vehicle.VehicleListDTO;
import com.parking.mediterranean.condominium.parking.dto.vehicle.VehicleUpdateDTO;
import com.parking.mediterranean.condominium.parking.entity.Apartment;
import com.parking.mediterranean.condominium.parking.entity.Vehicle;
import com.parking.mediterranean.condominium.parking.entity.enums.ApartmentType;
import com.parking.mediterranean.condominium.parking.exception.DuplicateResourceException;
import com.parking.mediterranean.condominium.parking.exception.ResourceNotFoundException;
import com.parking.mediterranean.condominium.parking.exception.VehicleConflictException;
import com.parking.mediterranean.condominium.parking.repository.ApartmentRepository;
import com.parking.mediterranean.condominium.parking.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;
    @Autowired
    private ApartmentRepository apartmentRepository;

    @Transactional
    public Long create(VehicleCreateDTO data) {
        checkPlateAvailable(data.plate());

        Vehicle vehicle = new Vehicle(data.plate(), data.model(), data.color());
        vehicle.setApartment(findApartment(data.apartmentId()));

        repository.save(vehicle);
        return vehicle.getId();
    }

    public Page<VehicleListDTO> list(Pageable pageable) {
        return repository.findAll(pageable)
                .map(VehicleListDTO::new);
    }

    @Transactional
    public void update(Long id, VehicleUpdateDTO data) {
        Vehicle vehicle = findVehicle(id);

        if (data.apartmentId() != null && !vehicle.getApartment().getId().equals(data.apartmentId())) {
            Apartment newApartment = findApartment(data.apartmentId());
            if (data.parked() != null && data.parked()) {
                checkParkingCapacity(newApartment);
            }
            vehicle.setApartment(newApartment);
        }

        if (data.parked() != null) {

            if (data.parked()) {
                checkParkingCapacity(vehicle.getApartment());
                vehicle.setParked(true);
            } else {
                vehicle.setParked(false);
            }
        }
    }

    @Transactional
    public void delete(Long id) {
        Vehicle vehicle = findVehicle(id);
        repository.delete(vehicle);
    }

    private void checkParkingCapacity(Apartment apartment) {

        long parkedCount = repository.countByApartmentIdAndParked(apartment.getId(), true);

        if (apartment.getApartmentType() == ApartmentType.STANDARD && parkedCount >= 1)
            throw new VehicleConflictException("This apartment already has a parked vehicle");

        if (apartment.getApartmentType() == ApartmentType.COVERAGE && parkedCount >= 2)
            throw new VehicleConflictException("This coverage apartment has reached parking limit");
    }

    private Vehicle findVehicle(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));
    }

    private Apartment findApartment(Long apartmentId) {
        return apartmentRepository.findById(apartmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Apartment not found"));
    }

    private void checkPlateAvailable(String plate) {
        if (repository.existsByPlate(plate)) {
            throw new DuplicateResourceException("Plate already exists");
        }
    }
}
