package com.davidproject.usedcar.dto;

import com.davidproject.usedcar.model.Car;

import java.util.List;

public record UsedCarUserDto(
        Long id,
        String auth0Id,
        String email
) {}
