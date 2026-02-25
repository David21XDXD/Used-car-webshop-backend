package com.davidproject.usedcar.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private String mileage;
    private String engineCapacity;
    @Enumerated(EnumType.STRING)
    private EngineType engineType;
    @Enumerated(EnumType.STRING)
    private Fuel fuel;
    @Enumerated(EnumType.STRING)
    private Transmission transmission;
    @Enumerated(EnumType.STRING)
    private Drive drive;
    private String color;
    private Integer doors;
    private Integer seats;
    @Enumerated(EnumType.STRING)
    private CarType carType;
    private Double price;
    private String image;
    private String description;
    @Transient
    private List<Extras> extras = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsedCarUser user;
}
