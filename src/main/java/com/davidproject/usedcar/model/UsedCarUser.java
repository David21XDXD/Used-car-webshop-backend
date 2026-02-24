package com.davidproject.usedcar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

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
}
