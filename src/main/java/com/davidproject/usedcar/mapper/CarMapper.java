package com.davidproject.usedcar.mapper;

import com.davidproject.usedcar.dto.CarRequest;
import com.davidproject.usedcar.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    Car toCar(CarRequest request);
}
