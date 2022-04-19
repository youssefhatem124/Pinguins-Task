package com.tracker.mapper;

import com.tracker.dto.ValidDroneDto;
import com.tracker.entities.Developer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ValidDroneMapper {

    ValidDroneMapper INSTANCE = Mappers.getMapper(ValidDroneMapper.class);

    ValidDroneDto entityToValidDto(Developer developer);
    Developer validDtoToEntity(ValidDroneDto validDroneDto);
}
