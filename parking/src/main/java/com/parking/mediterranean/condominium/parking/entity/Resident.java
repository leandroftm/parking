package com.parking.mediterranean.condominium.parking.entity;


import com.parking.mediterranean.condominium.parking.entity.enums.ResidentType;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "residents")
public class Resident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(nullable = false, length = 60)
    private String name;
    @Column(nullable = false, unique = true, length = 15)
    private String cpf;
    @Column(nullable = false, length = 15)
    private String phone;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ResidentType type;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_id", nullable = false)
    private Apartment apartment;

    public Resident(String name,String cpf, String phone, ResidentType type) {
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", phone='" + phone + '\'' +
                ", type=" + type +
                '}';
    }
}
