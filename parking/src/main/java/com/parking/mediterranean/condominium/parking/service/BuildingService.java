package com.parking.mediterranean.condominium.parking.service;

import com.parking.mediterranean.condominium.parking.dto.buiding.BuildingListDTO;
import com.parking.mediterranean.condominium.parking.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {

    @Autowired
    BuildingRepository repository;

    public Page<BuildingListDTO> list(Pageable page){
        return repository.findAllByOrderByCodeAsc(page).map(BuildingListDTO::new);
    }
}
