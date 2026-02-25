package com.davidproject.usedcar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsedCarUser {
    @Id
    @GeneratedValue
    private Long id;
    private String auth0Id;
    private String email;
    @OneToMany(mappedBy = "user")
    private List<Car> cars;
}
