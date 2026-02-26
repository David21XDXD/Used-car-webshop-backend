package com.davidproject.usedcar.mapper;

import com.davidproject.usedcar.dto.CarImageDto;
import com.davidproject.usedcar.model.CarImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    @Mapping(target = "car", ignore = true)
    List<CarImageDto> toDtoList(List<CarImage> carImage);
}
