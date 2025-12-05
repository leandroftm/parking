package com.parking.mediterranean.condominium.parking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = "apartments")
@Table(name = "buildings")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(nullable = false, length = 2)
    private String code;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer floors;
    @Column(nullable = false)
    private Integer apartmentsPerFloor;
    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Apartment> apartments = new ArrayList<>();

    public void setApartments(List<Apartment> apartments) {
        this.apartments.clear();
        if (apartments != null) {
            apartments.forEach(this::addApartment);
        }
    }

    public void addApartment(Apartment apartment) {
        apartment.setBuilding(this);
        this.apartments.add(apartment);
    }
}