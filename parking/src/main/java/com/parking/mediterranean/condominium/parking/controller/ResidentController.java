package com.parking.mediterranean.condominium.parking.controller;


import com.parking.mediterranean.condominium.parking.dto.resident.ResidentCreateDTO;
import com.parking.mediterranean.condominium.parking.dto.resident.ResidentListDTO;
import com.parking.mediterranean.condominium.parking.dto.resident.ResidentUpdateDTO;
import com.parking.mediterranean.condominium.parking.service.ResidentService;
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
@RequestMapping("/residents")
public class ResidentController {

    @Autowired
    private ResidentService service;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid ResidentCreateDTO data) {
        Long id = service.create(data);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<ResidentListDTO>> list(@PageableDefault(size = 30) Pageable pageable) {
        Page<ResidentListDTO> page = service.list(pageable);
        return ResponseEntity.ok(page);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody @Valid ResidentUpdateDTO data) {
        service.update(id, data);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
