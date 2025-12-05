package com.parking.mediterranean.condominium.parking.entity;

import com.parking.mediterranean.condominium.parking.entity.enums.ApartmentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"building", "residents", "vehicles", "bicycles"})
@Table(name = "apartments", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"building_id", "number"})
})
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull
    @Column(nullable = false, length = 4)
    private String number;
    @Column(nullable = false)
    private Integer floor;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ApartmentType apartmentType;
    @ManyToOne(optional = false)
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;
    @OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL)
    private List<Resident> residents = new ArrayList<>();
    @OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL)
    private List<Vehicle> vehicles = new ArrayList<>();
    @OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL)
    private List<Bicycle> bicycles = new ArrayList<>();


    private void setResidents(List<Resident> residents) {
        this.residents.clear();
        if (residents != null)
            residents.forEach(this::addResident);
    }

    private void addResident(Resident resident) {
        resident.setApartment(this);
        this.residents.add(resident);
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles.clear();
        if (vehicles != null)
            vehicles.forEach(this::addVehicles);
    }

    private void addVehicles(Vehicle vehicle) {
        vehicle.setApartment(this);
        this.vehicles.add(vehicle);
    }

    public void setBicycles(List<Bicycle> bicycles) {
        this.bicycles.clear();
        if (bicycles != null)
            bicycles.forEach(this::addBicycles);
    }

    private void addBicycles(Bicycle bicycle) {
        bicycle.setApartment(this);
        this.bicycles.add(bicycle);
    }
}
