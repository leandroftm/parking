package com.parking.mediterranean.condominium.parking.controller;

import com.parking.mediterranean.condominium.parking.dto.apartment.ApartmentListDTO;
import com.parking.mediterranean.condominium.parking.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apartments")
public class ApartmentController {

    @Autowired
    private ApartmentService service;

    @GetMapping
    public ResponseEntity<Page<ApartmentListDTO>> list(@PageableDefault(size = 20)Pageable pageable){
        Page<ApartmentListDTO> page = service.list(pageable);
        return ResponseEntity.ok(page);
    }
}
