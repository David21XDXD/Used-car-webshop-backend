package com.davidproject.usedcar.mapper;

import com.davidproject.usedcar.dto.CarCardDetails;
import com.davidproject.usedcar.dto.CarRequest;
import com.davidproject.usedcar.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ImageMapper.class})
public interface CarMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    Car toCar(CarRequest request);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "extras", ignore = true)
    List<CarCardDetails> toDtoList(List<Car> cars);
}
