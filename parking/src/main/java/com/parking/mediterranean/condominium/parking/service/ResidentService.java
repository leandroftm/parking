package com.parking.mediterranean.condominium.parking.service;

import com.parking.mediterranean.condominium.parking.dto.resident.ResidentCreateDTO;
import com.parking.mediterranean.condominium.parking.dto.resident.ResidentListDTO;
import com.parking.mediterranean.condominium.parking.dto.resident.ResidentUpdateDTO;
import com.parking.mediterranean.condominium.parking.entity.Apartment;
import com.parking.mediterranean.condominium.parking.entity.Resident;
import com.parking.mediterranean.condominium.parking.entity.enums.ResidentType;
import com.parking.mediterranean.condominium.parking.exception.BadRequestException;
import com.parking.mediterranean.condominium.parking.exception.DuplicateResourceException;
import com.parking.mediterranean.condominium.parking.exception.PrimaryResidentConflictException;
import com.parking.mediterranean.condominium.parking.exception.ResourceNotFoundException;
import com.parking.mediterranean.condominium.parking.repository.ApartmentRepository;
import com.parking.mediterranean.condominium.parking.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResidentService {

    @Autowired
    private ResidentRepository repository;
    @Autowired
    private ApartmentRepository apartmentRepository;

    @Transactional
    public Long create(ResidentCreateDTO data) {
        ensureCpfAvailable(data.cpf());
        ensurePhoneAvailable(data.phone());

        Apartment apartment = findApartment(data.apartmentId());

        ensurePrimaryResidentAvailable(data.type(), apartment.getId());

        Resident resident = new Resident(data.name(), data.cpf(), data.phone(), data.type());
        resident.setApartment(apartment);
        try {
            repository.save(resident);
            return resident.getId();

        } catch (DataIntegrityViolationException e) {
            String msg = e.getMostSpecificCause().getMessage();

            if (msg.contains("cpf")) {
                throw new DuplicateResourceException("CPF already exists");
            }
            if (msg.contains("phone")) {
                throw new DuplicateResourceException("Phone already exists");
            }
            throw new DuplicateResourceException("Duplicate field detected");
        }
    }

    public Page<ResidentListDTO> list(Pageable pageable) {
        return repository.findAllByOrderByApartment_NumberAscApartment_Building_CodeAscNameAsc(pageable)
                .map(ResidentListDTO::new);
    }

    @Transactional
    public void update(Long id, ResidentUpdateDTO data) {
        Resident resident = findResident(id);

        Long currentApartmentId = resident.getApartment().getId();
        Long newApartmentId = data.apartmentId();
        if (newApartmentId == null || newApartmentId.equals(currentApartmentId)) {
            return;
        }
        apartmentExists(newApartmentId);

        ensurePrimaryResidentAvailable(resident.getType(), newApartmentId);

        resident.setApartment(findApartment(newApartmentId));
    }

    @Transactional
    public void delete(Long id) {
        Resident resident = findResident(id);
        repository.delete(resident);
    }

    private void apartmentExists(Long apartmentId) {
        if (!apartmentRepository.existsById(apartmentId))
            throw new BadRequestException("apartment does not exist");
    }

    private Resident findResident(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resident not found"));
    }

    private Apartment findApartment(Long apartmentId) {
        return apartmentRepository.findById(apartmentId).orElseThrow(() -> new ResourceNotFoundException("Apartment not found"));
    }

    private void ensureCpfAvailable(String cpf) {
        if (repository.existsByCpf(cpf))
            throw new BadRequestException("cpf already exists");
    }

    private void ensurePhoneAvailable(String phone) {
        if (repository.existsByPhone(phone))
            throw new BadRequestException("phone already exists");
    }

    private void ensurePrimaryResidentAvailable(ResidentType type, Long apartmentId) {
        if (type == ResidentType.PRIMARY && repository.existsByApartmentIdAndType(apartmentId, ResidentType.PRIMARY))
            throw new PrimaryResidentConflictException("This apartment already has a primary resident");
    }

}
