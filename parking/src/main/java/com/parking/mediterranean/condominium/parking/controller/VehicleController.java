package com.parking.mediterranean.condominium.parking.controller;

import com.parking.mediterranean.condominium.parking.dto.vehicle.VehicleCreateDTO;
import com.parking.mediterranean.condominium.parking.dto.vehicle.VehicleListDTO;
import com.parking.mediterranean.condominium.parking.dto.vehicle.VehicleUpdateDTO;
import com.parking.mediterranean.condominium.parking.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid VehicleCreateDTO data){
        Long id = service.create(data);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<VehicleListDTO>> list(@PageableDefault (size = 30)Pageable pageable){
        Page<VehicleListDTO> page = service.list(pageable);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody @Valid VehicleUpdateDTO data){
        service.update(id, data);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
