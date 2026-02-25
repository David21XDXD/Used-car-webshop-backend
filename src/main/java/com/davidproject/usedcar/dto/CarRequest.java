package com.davidproject.usedcar.dto;

import com.davidproject.usedcar.model.Extras;

import java.util.List;

public record CarRequest(
        String brand,
        String model,
        Integer year,
        Integer mileage,
        String engineCapacity,
        String engineType,
        String fuel,
        String transmission,
        String drive,
        String carType,
        String color,
        Integer doors,
        Integer seats,
        String image,
        Double price,
        String description,
        List<Extras> extras
) {}
