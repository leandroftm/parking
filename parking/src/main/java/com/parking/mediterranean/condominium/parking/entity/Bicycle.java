package com.parking.mediterranean.condominium.parking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = "apartment")
@Table(name = "bicycles")
public class Bicycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(length = 30)
    private String model;

    @Column(nullable = false, length = 30)
    private String color;

    @Column(nullable = false, unique = true, length = 15)
    private String identifier;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    public Bicycle(String model, String color, String identifier) {
        this.model = model;
        this.color = color;
        this.identifier = identifier;
    }
}
