package com.davidproject.usedcar.dto;

import java.util.List;

public record CarCardDetails(
        Long id,
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
        List<CarImageDto> images,
        Double price,
        String description
) {}
