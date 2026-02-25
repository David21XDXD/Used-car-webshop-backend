package com.davidproject.usedcar.mapper;

import com.davidproject.usedcar.dto.UsedCarUserDto;
import com.davidproject.usedcar.model.UsedCarUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsedCarUserMapper {
    @Mapping(target = "cars", ignore = true)
    UsedCarUser toUser(UsedCarUserDto dto);
    UsedCarUserDto toDto(UsedCarUser user);
}
