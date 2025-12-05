package com.parking.mediterranean.condominium.parking.controller;

import com.parking.mediterranean.condominium.parking.dto.buiding.BuildingListDTO;
import com.parking.mediterranean.condominium.parking.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buildings")
public class BuildingController {

    @Autowired
    BuildingService service;

    @GetMapping
    public ResponseEntity<Page<BuildingListDTO>> list(@PageableDefault(size = 5, sort = "code") Pageable pageable) {
        Page<BuildingListDTO> page = service.list(pageable);
        return ResponseEntity.ok(page);
    }
}
