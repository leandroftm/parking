package com.parking.mediterranean.condominium.parking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = "apartment")
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(nullable = false, unique = true, length = 15)
    private String plate;
    @Column(nullable = false, length = 30)
    private String model;
    @Column(nullable = false, length = 30)
    private String color;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;
    @Column(nullable = false)
    private boolean parked;

    public Vehicle(String plate, String model, String color) {
        this.plate = plate.toUpperCase();
        this.model = model;
        this.color = color;
        this.parked = false;
    }

    public void setPlate(String plate) {
        this.plate = plate.toUpperCase();
    }
}
